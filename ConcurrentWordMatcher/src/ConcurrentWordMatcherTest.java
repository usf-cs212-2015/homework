import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class ConcurrentWordMatcherTest {

    private static final String regex = "(?i)guten.*";

    private static final long LONG_TIMEOUT = 60000;
    private static final long SMALL_TIMEOUT = 30000;

    @RunWith(Parameterized.class)
    public static class SingleFileTests {

        private Path testcase;
        private int expected;

        @Parameters(name = "{0}: {1} matches")
        public static Iterable<Object[]> data() {
            return Arrays.asList(new Object[][] {
                { Paths.get("text", "11.txt"), 87 },
                { Paths.get("text", "98.txt"), 87 },
                { Paths.get("text", "1322.txt"), 87 },
                { Paths.get("text", "1342.txt"), 87 },
                { Paths.get("text", "1661.txt"), 89 }
            });
        }

        public SingleFileTests(Path testcase, int expected) {
            this.testcase = testcase;
            this.expected = expected;
        }

        @Before
        public void before() {
            Assert.assertTrue(Files.isReadable(testcase));
        }

        @Test(timeout=SMALL_TIMEOUT)
        public void test() {
            ConcurrentWordMatcher matcher = new ConcurrentWordMatcher();
            matcher.parseTextFiles(testcase, regex);

            int actual = matcher.getCount(regex);
            Assert.assertEquals(expected, actual);

            matcher.shutdown();
        }
    }

    @RunWith(Parameterized.class)
    public static class DirectoryTests {
        private Path testcase;
        private int expected;

        @Parameters(name = "{0}: {1} matches")
        public static Iterable<Object[]> data() {
            return Arrays.asList(new Object[][] {
                { Paths.get("text"), 437 },
                { Paths.get("."), 437 },
                { Paths.get("src"), 0 }
            });
        }

        public DirectoryTests(Path testcase, int expected) {
            this.testcase = testcase;
            this.expected = expected;
        }

        @Before
        public void before() {
            Assert.assertTrue(Files.isReadable(testcase));
        }

        @Test(timeout=LONG_TIMEOUT)
        public void test() {
            ConcurrentWordMatcher matcher = new ConcurrentWordMatcher();
            matcher.parseTextFiles(testcase, regex);

            int actual = matcher.getCount(regex);
            Assert.assertEquals(expected, actual);

            matcher.shutdown();
        }
    }

    public static class ComplexTests {

        @Test(timeout=LONG_TIMEOUT)
        public void testTwoFiles() {
            ConcurrentWordMatcher matcher = new ConcurrentWordMatcher();
            matcher.parseTextFiles(Paths.get("text", "11.txt"), regex);
            matcher.parseTextFiles(Paths.get("text", "98.txt"), regex);

            int expected = 174;
            int actual = matcher.getCount(regex);

            Assert.assertEquals(expected, actual);

            matcher.shutdown();
        }

        @Test(timeout=SMALL_TIMEOUT)
        public void testNoMatches() {
            ConcurrentWordMatcher matcher = new ConcurrentWordMatcher();
            matcher.parseTextFiles(Paths.get("text"), "ALPACA");

            int expected = 0;
            int actual = matcher.getCount("ALPACA");

            Assert.assertEquals(expected, actual);

            matcher.shutdown();
        }

        @Test(timeout=LONG_TIMEOUT)
        public void testTwoRegex() {
            ConcurrentWordMatcher matcher = new ConcurrentWordMatcher();
            matcher.parseTextFiles(Paths.get("text", "11.txt"), regex);
            matcher.parseTextFiles(Paths.get("text", "11.txt"), "(?i)alice");

            int expected = 221;
            int actual = matcher.getCount("(?i)alice");

            Assert.assertEquals(expected, actual);

            matcher.shutdown();
        }
    }

    public static class BenchmarkTests {

        /**
         * Performs the specified number of warmup rounds, and then measures
         * the average number of seconds for the remaining rounds.
         *
         * @param warmup  warmup rounds
         * @param rounds  tested rounds
         * @return average runtime in seconds
         */
        public double timeSingle(int warmup, int rounds) {
            for (int i = 0; i < warmup; i++) {
                TextFileWordMatcher.parseTextFiles(Paths.get("."), regex);
            }

            long start = System.nanoTime();

            for (int i = 0; i < rounds; i++) {
                TextFileWordMatcher.parseTextFiles(Paths.get("."), regex);
            }

            long end = System.nanoTime();

            double average = end - start;
            average /= rounds;
            average /= 1000000000;

            return average;
        }

        /**
         * Performs the specified number of warmup rounds, and then measures
         * the average number of seconds for the remaining rounds.
         *
         * @param warmup  warmup rounds
         * @param rounds  tested rounds
         * @return average runtime in seconds
         */
        public double timeMulti(int warmup, int rounds) {
            for (int i = 0; i < warmup; i++) {
                ConcurrentWordMatcher matcher = new ConcurrentWordMatcher();
                matcher.parseTextFiles(Paths.get("."), regex);
                matcher.shutdown();
            }

            long start = System.nanoTime();

            for (int i = 0; i < rounds; i++) {
                ConcurrentWordMatcher matcher = new ConcurrentWordMatcher();
                matcher.parseTextFiles(Paths.get("."), regex);
                matcher.shutdown();
            }

            long end = System.nanoTime();

            double average = end - start;
            average /= rounds;
            average /= 1000000000;

            return average;
        }

        @Test(timeout=LONG_TIMEOUT)
        public void benchmark() {
            int warmup = 5;
            int rounds = 10;

            double singleAverage = timeSingle(warmup, rounds);
            double multiAverage = timeMulti(warmup, rounds);

            String debug = String.format("single: %.5f multi: %.5f %n",
                    singleAverage, multiAverage);
            System.out.println(debug);

            Assert.assertTrue(debug, multiAverage < singleAverage);
        }
    }

}

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
public class TextFileWordMatcherTest {

    private static final String regex = "(?i)guten.*";

    @RunWith(Parameterized.class)
    public static class SingleFileTest {

        private Path testcase;
        private int expected;

        @Parameters(name = "{index}: {0} ({1} matches)")
        public static Iterable<Object[]> data() {
            return Arrays.asList(new Object[][] {
                { Paths.get("text", "11.txt"), 87 },
                { Paths.get("text", "98.txt"), 87 },
                { Paths.get("text", "1322.txt"), 87 },
                { Paths.get("text", "1342.txt"), 87 },
                { Paths.get("text", "1661.txt"), 89 }
            });
        }

        public SingleFileTest(Path testcase, int expected) {
            this.testcase = testcase;
            this.expected = expected;
        }

        @Before
        public void setup() {
            Assert.assertTrue(Files.isReadable(testcase));
        }

        @Test
        public void testCount() {
            int actual = TextFileWordMatcher.countWords(testcase, regex);
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void testParse() {
            int actual = TextFileWordMatcher.parseTextFiles(testcase, regex);
            Assert.assertEquals(expected, actual);
        }
    }

    public static class DirectoryTest {
        @Test
        public void testTextDirectory() {
            Path testcase = Paths.get("text");
            int expected = 437;
            int actual = TextFileWordMatcher.parseTextFiles(testcase, regex);
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void testCurrentDirectory() {
            Path testcase = Paths.get(".");
            int expected = 437;
            int actual = TextFileWordMatcher.parseTextFiles(testcase, regex);
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void testSourceDirectory() {
            Path testcase = Paths.get("src");
            int expected = 0;
            int actual = TextFileWordMatcher.parseTextFiles(testcase, regex);
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void testNoMatches() {
            Path testcase = Paths.get("text");
            int expected = 0;
            int actual = TextFileWordMatcher.parseTextFiles(testcase, "ALPACA");
            Assert.assertEquals(expected, actual);
        }
    }

}

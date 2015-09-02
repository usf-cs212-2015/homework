import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        WordIndexTest.BasicTestCase.class, 
        WordIndexTest.SimpleTestCase.class, 
        WordIndexTest.ComplexTestCase.class
})
public class WordIndexTest {

    /** Prevents tests from running forever. */
    @Rule
    public TestRule globalTimeout = Timeout.seconds(10);

    /**
     * Provides basic tests. Try to pass these tests before all others.
     */
    public static class BasicTestCase {
        @Test
        public void testCleanCases() {
            String word = "aPPleSAuce";
            String result = WordIndex.clean(word);
            Assert.assertEquals(word, "applesauce", result);
        }
        
        @Test
        public void testCleanSpaces() {
            String word = "  pineapple  \t\n";
            String result = WordIndex.clean(word);
            Assert.assertEquals(word,  "pineapple", result);
        }
        
        @Test
        public void testSingleAdd() {
            WordIndex index = new WordIndex();
            boolean result = index.add("hello", 1);
            Assert.assertTrue(index.toString(), result);
        }
        
        @Test
        public void testCleanedAdd() {
            WordIndex index = new WordIndex();
            String word = "  CrABAppLE\n"; 
            index.add(word, 1);
            boolean result = index.contains("crabapple");
            Assert.assertTrue(index.toString(), result);
        }

        @Test
        public void testDoubleAddResult() {
            WordIndex index = new WordIndex();
            index.add("hello", 1);
            boolean result = index.add("hello", 2);
            Assert.assertTrue(index.toString(), result);
        }

        @Test
        public void testDoubleAddCount() {
            WordIndex index = new WordIndex();
            index.add("hello", 1);
            index.add("hello", 2);
            int result = index.count("hello");
            Assert.assertEquals(index.toString(), 2, result);
        }
        
        
        @Test
        public void testDuplicateAddResult() {
            WordIndex index = new WordIndex();
            index.add("hello", 1);
            boolean result = index.add("hello", 1);
            Assert.assertFalse(index.toString(), result);
        }

        @Test
        public void testDuplicateAddCount() {
            WordIndex index = new WordIndex();
            index.add("hello", 1);
            index.add("hello", 1);
            int result = index.count("hello");
            Assert.assertEquals(index.toString(), 1, result);
        }        
        
        @Test
        public void testCleanContains() {
            WordIndex index = new WordIndex();
            index.add("applejacks", 1);
            boolean result = index.contains("\tapPleJAcks \n");
            Assert.assertTrue(index.toString(), result);
        }

        @Test
        public void testCleanCount() {
            WordIndex index = new WordIndex();
            index.add("applejacks", 1);
            int result = index.count("\tapPleJAcks \n");
            Assert.assertEquals(index.toString(), 1, result);
        }
        
        @Test
        public void testEmptyWords() {
            WordIndex index = new WordIndex();
            Assert.assertEquals(0, index.words());
        }

        @Test
        public void testEmptyCount() {
            WordIndex index = new WordIndex();
            Assert.assertEquals(0, index.count("nothing"));
        }

        @Test
        public void testEmptyPositions() {
            WordIndex index = new WordIndex();
            Assert.assertTrue(index.positions("nothing").isEmpty());
        }
        
        @Test
        public void testAddAllSingle() {
            WordIndex index = new WordIndex();
            index.addAll(new String[] { "ant" });
            boolean result = index.positions("ant").contains(1);
            Assert.assertTrue(index.toString(), result);
        }
        
        @Test
        public void testAddAllDuplicate() {
            WordIndex index = new WordIndex();
            index.addAll(new String[] { "ant", "ant", "bat" });
            int result = index.words();
            Assert.assertEquals(index.toString(), 2, result);            
        }
        
        @Test
        public void testAddAllDuplicateClean() {
            WordIndex index = new WordIndex();
            index.addAll(new String[] { "ant  ", "\nANT", "bat" });
            int result = index.words();
            Assert.assertEquals(index.toString(), 2, result);            
        }
    }

    /**
     * Tests focused on position for a simple test case.
     */
    public static class SimpleTestCase {

        /** Simple test case with repeated words. */
        public static final String[] testCase = {
                "ant", "ant", "bat", "cat"
        };

        /** The WordIndex to test. */
        private WordIndex index;

        @Before
        public void setup() {
            index = new WordIndex();
            index.addAll(testCase);
        }

        @Test
        public void testCountAnt() {
            Assert.assertEquals(index.toString(), 2, index.count("ant"));
        }

        @Test
        public void testCountBat() {
            Assert.assertEquals(index.toString(), 1, index.count("bat"));
        }

        @Test
        public void testCountRat() {
            Assert.assertEquals(index.toString(), 0, index.count("rat"));
        }

        @Test
        public void testWords() {
            Assert.assertEquals(index.toString(), 3, index.words());
        }

        @Test
        public void testContainsCat() {
            Assert.assertTrue(index.toString(), index.contains("cat"));
        }

        @Test
        public void testContainsRat() {
            Assert.assertFalse(index.toString(), index.contains("rat"));
        }

        @Test
        public void testPosition1() {
            Assert.assertTrue(index.toString(), index.positions("ant").contains(1));
        }

        @Test
        public void testPosition2() {
            Assert.assertTrue(index.toString(), index.positions("ant").contains(2));
        }

        @Test
        public void testPosition3() {
            Assert.assertTrue(index.toString(), index.positions("bat").contains(3));
        }

        @Test
        public void testPosition4() {
            Assert.assertTrue(index.toString(), index.positions("cat").contains(4));
        }
    }

    /**
     * Tests a more complex test case, and whether references are being handled
     * properly. Worry about these tests LAST.
     */
    public static class ComplexTestCase {
        /** Complex test case with repeated words. */
        public static final String[] testCase = {
                "owl", "bat", "ant", "fly", "emu", "rat", "boa", "elk", "hen", "dog", "eel", "fox", "doe", "owl", "bee",
                "eel", "yak", "cow", "eel", "bee", "ape", "pig", "cat", "ant", "fox"
        };

        /** The WordIndex to test. */
        private WordIndex index;

        @Before
        public void setup() {
            index = new WordIndex();
            index.addAll(testCase);
        }

        @Test
        public void testAntCount() {
            Assert.assertEquals(index.toString(), 2, index.count("ant"));
        }

        @Test
        public void testEelCount() {
            Assert.assertEquals(index.toString(), 3, index.count("eel"));
        }

        @Test
        public void testWords() {
            Assert.assertEquals(index.toString(), 19, index.words());
        }

        @Test
        public void testPositions() {
            Set<Integer> positions = new HashSet<Integer>();
            positions.addAll(Arrays.asList(new Integer[] {
                    11, 16, 19
            }));
            Assert.assertTrue(index.toString(), index.positions("eel").equals(positions));
        }

        @Test
        public void testMutability() {
            Set<Integer> positions = new HashSet<Integer>();
            positions.addAll(Arrays.asList(new Integer[] {
                    11, 16, 19
            }));

            /*
             * This test tries to modify the positions stored by the word index.
             * If you are improperly passing around references, this test will
             * fail.
             */
            try {
                index.positions("eel").clear();
            }
            catch (Exception ignored) {
                // ignored
            }

            Assert.assertTrue(index.toString(), index.positions("eel").equals(positions));
        }
    }
}

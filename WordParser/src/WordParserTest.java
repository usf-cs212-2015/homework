import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    WordParserTest.CleanTest.class,
    WordParserTest.SplitTest.class,
    WordParserTest.UniqueTest.class
})
public class WordParserTest {

    /**
     * Tests the {@link WordParser#clean(String)} method.
     */
    public static class CleanTest {

        @Test
        public void testEmptyString() {
            String mytest = "";
            String expect = "";
            String actual = WordParser.clean(mytest);
            Assert.assertEquals(expect, actual);
        }

        @Test
        public void testOnlyTab() {
            String mytest = "\t";
            String expect = "";
            String actual = WordParser.clean(mytest);
            Assert.assertEquals(expect, actual);
        }

        @Test
        public void testOnlyWhitespace() {
            String mytest = "    ";
            String expect = "";
            String actual = WordParser.clean(mytest);
            Assert.assertEquals(expect, actual);
        }

        @Test
        public void testMiddleTab() {
            String mytest = "a\tb";
            String expect = "a\tb";
            String actual = WordParser.clean(mytest);
            Assert.assertEquals(expect, actual);
        }
        
        @Test
        public void testSingleSpecialCharacter() {
            String mytest = "+";
            String expect = "";
            String actual = WordParser.clean(mytest);
            Assert.assertEquals(expect, actual);
        }
        
        @Test
        public void testSingleUnderscore() {
            String mytest = "_";
            String expect = "";
            String actual = WordParser.clean(mytest);
            Assert.assertEquals(expect, actual);
        }
        
        @Test
        public void testSingleCapitalLetter() {
            String mytest = "A";
            String expect = "a";
            String actual = WordParser.clean(mytest);
            Assert.assertEquals(expect, actual);
        }
        
        @Test
        public void testSingleDigit() {
            String mytest = "4";
            String expect = "4";
            String actual = WordParser.clean(mytest);
            Assert.assertEquals(expect, actual);
        }
        
        @Test
        public void testSurroundingWhitespace() {
            String mytest = "  abc  ";
            String expect = "abc";
            String actual = WordParser.clean(mytest);
            Assert.assertEquals(expect, actual);
        }
        
        @Test
        public void testUmlaut() {
            String mytest = "ü";
            String expect = "ü";
            String actual = WordParser.clean(mytest);
            Assert.assertEquals(expect, actual);
        } 
        
        @Test
        public void testHelloWorld() {
            String mytest = "Hello, world!";
            String expect = "hello world";
            String actual = WordParser.clean(mytest);
            Assert.assertEquals(expect, actual);
        }

        @Test
        public void testHypenated() {
            String mytest = "dragon-fly";
            String expect = "dragonfly";
            String actual = WordParser.clean(mytest);
            Assert.assertEquals(expect, actual);
        }
        
        @Test
        public void testEmailAddress() {
            String mytest = "sjengle@cs.usfca.edu";
            String expect = "sjenglecsusfcaedu";
            String actual = WordParser.clean(mytest);
            Assert.assertEquals(expect, actual);
        }
        
        @Test
        public void testComplex() {
            String mytest = "\t heLLo, there! Do you have _10_ apples?\n";
            String expect = "hello there do you have 10 apples";
            String actual = WordParser.clean(mytest);
            Assert.assertEquals(expect, actual);
        }        
    }
    
    /**
     * Tests the {@link WordParser#split(String)} method.
     */
    public static class SplitTest {
        @Test
        public void testSingleLetter() {
            String mytest = "A";
            String[] expect = new String[] {"a"};
            String[] actual = WordParser.split(mytest);
            Assert.assertArrayEquals(expect, actual);
        }
        
        @Test
        public void testSimpleWords() {
            String mytest = "pizza pie";
            String[] expect = new String[] {"pizza", "pie"};
            String[] actual = WordParser.split(mytest);
            Assert.assertArrayEquals(expect, actual);
        }
        
        @Test
        public void testSpecialCharacters() {
            String mytest = "  résumé & e-X-posé!";
            String[] expect = new String[] {"résumé", "exposé"};
            String[] actual = WordParser.split(mytest);
            Assert.assertArrayEquals(expect, actual);
        }
        
        @Test
        public void testEmptyString() {
            String mytest = "";
            String[] expect = new String[] {};
            String[] actual = WordParser.split(mytest);
            Assert.assertArrayEquals(expect, actual);
        }

        @Test
        public void testWhitespace() {
            String mytest = "   \t \n  ";
            String[] expect = new String[] {};
            String[] actual = WordParser.split(mytest);
            Assert.assertArrayEquals(expect, actual);
        }        
        
        @Test
        public void testOnlySpecialCharacters() {
            String mytest = "<(^_^<) <(^_^)> (>^_^)>";
            String[] expect = new String[] {};
            String[] actual = WordParser.split(mytest);
            Assert.assertArrayEquals(expect, actual);
        }        
    }

    /**
     * Tests the {@link WordParser#uniqueWords(String)} method.
     */
    public static class UniqueTest {
        @Test
        public void testAllSameWord() {
            String mytest = "pizza PiZZA p_i_z_z_a pI@zZa pi.zzA";
            
            Set<String> expect = new HashSet<String>();
            expect.add("pizza");
            
            Set<String> actual = WordParser.uniqueWords(mytest);
            Assert.assertEquals(expect, actual);
        }
        
        @Test
        public void testWithDuplicates() {
            String mytest = "ant bat cat elk cat dog elk";
            
            Set<String> expect = new HashSet<String>();
            Collections.addAll(expect, "ant", "bat", "cat", "dog", "elk");
            
            Set<String> actual = WordParser.uniqueWords(mytest);
            Assert.assertEquals(expect, actual);          
        }
        
        @Test
        public void testNoWords() {
            String mytest = "  \t+  @@ _ ****   ";
            Set<String> actual = WordParser.uniqueWords(mytest);            
            Assert.assertTrue(actual.toString(), actual.isEmpty());            
        }
        
        @Test
        public void testEmptyString() {
            String mytest = "";
            Set<String> actual = WordParser.uniqueWords(mytest);            
            Assert.assertTrue(actual.toString(), actual.isEmpty());             
        }
    }

}

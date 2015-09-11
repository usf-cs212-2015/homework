import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
    JSONTreeWriterTest.ArrayTest.class,
    JSONTreeWriterTest.ObjectTest.class,
    JSONTreeWriterTest.NestedTest.class,
    JSONTreeWriterTest.ExceptionTest.class
})
public class JSONTreeWriterTest {

    /**
     * Tests whether the output written to the provided path matches a list of
     * expected lines. Fails if the lines do not match, or if an exception occurs.
     * Extra spaces at the end of lines or extra blank lines can cause a mismatch.
     * 
     * @param expect list of lines
     * @param path to file with actual output
     */
    public static void compare(String filename) {
        try {
            Path expectPath = Paths.get(".", "expected", filename);
            Path actualPath = Paths.get(".", "output", filename);
            
            List<String> expect = Files.readAllLines(expectPath, Charset.forName("UTF-8"));
            List<String> actual = Files.readAllLines(actualPath, Charset.forName("UTF-8"));
            
            Assert.assertEquals(expect, actual);
        }
        catch (Exception e) {
            Assert.fail(e.toString());
        }
    }
    
    public static class ArrayTest {        
        @Test
        public void testSimple() throws IOException {
            String name = "array-simple.json";
            Path actual = Paths.get(".", "output", name);
            
            Files.createDirectories(actual.getParent());
            Files.deleteIfExists(actual);
            
            TreeSet<Integer> mytest = new TreeSet<>();
            Collections.addAll(mytest, 1, 2, 3);
            
            JSONTreeWriter.writeArray(actual, mytest);
            
            compare(name);
        }
        
        @Test
        public void testSingle() throws IOException {
            String name = "array-single.json";
            Path actual = Paths.get(".", "output", name);
            
            Files.createDirectories(actual.getParent());
            Files.deleteIfExists(actual);
            
            TreeSet<Integer> mytest = new TreeSet<>();
            Collections.addAll(mytest, 42);
            JSONTreeWriter.writeArray(actual, mytest);
            
            compare(name);
        }

        @Test
        public void testEmpty() throws IOException {
            String name = "array-empty.json";
            Path actual = Paths.get(".", "output", name);
            
            Files.createDirectories(actual.getParent());
            Files.deleteIfExists(actual);
            
            TreeSet<Integer> mytest = new TreeSet<>();
            JSONTreeWriter.writeArray(actual, mytest);

            compare(name);
        }
    }
    
    public static class ObjectTest {        
        @Test
        public void testSimple() throws IOException {
            String name = "object-simple.json";
            Path actual = Paths.get(".", "output", name);
            
            Files.createDirectories(actual.getParent());
            Files.deleteIfExists(actual);
            
            TreeMap<String, Integer> mytest = new TreeMap<>();
            mytest.put("apple", 5);
            mytest.put("banana", 6);
            mytest.put("carrot", 6);
            
            JSONTreeWriter.writeObject(actual, mytest);
          
            compare(name);
        }
        
        @Test
        public void testSingle() throws IOException {
            String name = "object-single.json";
            Path actual = Paths.get(".", "output", name);
            
            Files.createDirectories(actual.getParent());
            Files.deleteIfExists(actual);
            
            TreeMap<String, Integer> mytest = new TreeMap<>();
            mytest.put("hello", 42);
            
            JSONTreeWriter.writeObject(actual, mytest);
            
            compare(name);
        }

        @Test
        public void testEmpty() throws IOException {
            String name = "object-empty.json";
            Path actual = Paths.get(".", "output", name);
            
            Files.createDirectories(actual.getParent());
            Files.deleteIfExists(actual);

            TreeMap<String, Integer> mytest = new TreeMap<>();
            
            JSONTreeWriter.writeObject(actual, mytest);
            
            compare(name);
        }
    }
    
    public static class NestedTest {
        @Test
        public void testSimple() throws IOException {
            String name = "nested-simple.json";
            Path actual = Paths.get(".", "output", name);
            
            Files.createDirectories(actual.getParent());
            Files.deleteIfExists(actual);

            TreeMap<String, TreeSet<Integer>> mytest = new TreeMap<>();
            mytest.put("odd", new TreeSet<Integer>());
            mytest.put("even", new TreeSet<Integer>());
            Collections.addAll(mytest.get("odd"), 1, 3, 5);
            Collections.addAll(mytest.get("even"), 2, 4);
            
            JSONTreeWriter.writeNestedObject(actual, mytest);
            
            compare(name);
        }          

        @Test
        public void testSingleKey() throws IOException {
            String name = "nested-single-key.json";
            Path actual = Paths.get(".", "output", name);
            
            Files.createDirectories(actual.getParent());
            Files.deleteIfExists(actual);

            TreeMap<String, TreeSet<Integer>> mytest = new TreeMap<>();
            mytest.put("pizza", new TreeSet<Integer>());
            JSONTreeWriter.writeNestedObject(actual, mytest);
            
            compare(name);
        }        
        
        @Test
        public void testSingleValue() throws IOException {
            String name = "nested-single-value.json";
            Path actual = Paths.get(".", "output", name);
            
            Files.createDirectories(actual.getParent());
            Files.deleteIfExists(actual);

            TreeMap<String, TreeSet<Integer>> mytest = new TreeMap<>();
            mytest.put("pizza", new TreeSet<Integer>());
            mytest.get("pizza").add(42);
            JSONTreeWriter.writeNestedObject(actual, mytest);
            
            compare(name);
        }        
        
        @Test
        public void testEmpty() throws IOException {
            String name = "nested-empty.json";
            Path actual = Paths.get(".", "output", name);
            
            Files.createDirectories(actual.getParent());
            Files.deleteIfExists(actual);

            TreeMap<String, TreeSet<Integer>> mytest = new TreeMap<>();
            JSONTreeWriter.writeNestedObject(actual, mytest);
            
            compare(name);
        }
    }
    
    public static class ExceptionTest {
        
        @Test
        public void testUnwriteable() {
            try {
                Path actual = Files.createTempDirectory("cs212-temp");
                boolean value = JSONTreeWriter.writeArray(actual, new TreeSet<>());
                Assert.assertFalse(value);
            }
            catch (Exception e) {
                Assert.fail(e.getMessage());
            }
        }
    }
}

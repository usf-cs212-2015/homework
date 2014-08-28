import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Tests {@link WordParser} for correctness. All tests must pass to earn
 * a 100% on this homework assignment. Please note, however, that passing
 * all of these tests does not guarantee a 100% score.
 *
 * <p><em>
 * To run all of the unit tests in this class, right-click the outer class
 * name, select "Run As" and then "JUnit Test". You may also right-click
 * an individual inner class or unit test and follow the same procedure
 * to run just those tests instead.
 * </em></p>
 *
 * @see WordParser
 */
@RunWith(Suite.class)
@SuiteClasses({
	WordParserTest.CleanTextTest.class,
	WordParserTest.ParseTextTest.class,
	WordParserTest.ParseFileTest.class
})
public class WordParserTest {

	/**
	 * Tests the {@link WordParser#cleanText(String)} method.
	 */
	public static class CleanTextTest {

		@Test
		public void testEmptyString() {
			String mytest = "";
			String expect = "";
			String actual = WordParser.cleanText(mytest);
			Assert.assertEquals(expect, actual);
		}

		@Test
		public void testWhiteSpace() {
			String mytest = " \t ";
			String expect = "";
			String actual = WordParser.cleanText(mytest);
			Assert.assertEquals(expect, actual);
		}

		@Test
		public void testSingleCharacter() {
			String mytest = "+";
			String expect = "";
			String actual = WordParser.cleanText(mytest);
			Assert.assertEquals(expect, actual);
		}

		@Test
		public void testSingleUnderscore() {
			String mytest = "_";
			String expect = "";
			String actual = WordParser.cleanText(mytest);
			Assert.assertEquals(expect, actual);
		}

		@Test
		public void testSingleLetter() {
			String mytest = "A";
			String expect = "a";
			String actual = WordParser.cleanText(mytest);
			Assert.assertEquals(expect, actual);
		}

		@Test
		public void testSingleDigit() {
			String mytest = "1";
			String expect = "1";
			String actual = WordParser.cleanText(mytest);
			Assert.assertEquals(expect, actual);
		}

		@Test
		public void testHelloWorld() {
			String mytest = "Hello World!";
			String expect = "hello world";
			String actual = WordParser.cleanText(mytest);
			Assert.assertEquals(expect, actual);
		}

		@Test
		public void testHyphenated() {
			String mytest = "Dragon-Fly";
			String expect = "dragon fly";
			String actual = WordParser.cleanText(mytest);
			Assert.assertEquals(expect, actual);
		}

		@Test
		public void testEmail() {
			String mytest = "sjengle@cs.usfca.edu";
			String expect = "sjengle cs usfca edu";
			String actual = WordParser.cleanText(mytest);
			Assert.assertEquals(expect, actual);
		}

		@Test
		public void testMultiLine() {
			String mytest = "  a  \n  b  \n  c  ";
			String expect = "a b c";
			String actual = WordParser.cleanText(mytest);
			Assert.assertEquals(expect, actual);
		}

		@Test
		public void testComplex() {
			String mytest = "\t heLLo, there! \n Do you have *10* apples?";
			String expect = "hello there do you have 10 apples";
			String actual = WordParser.cleanText(mytest);
			Assert.assertEquals(expect, actual);
		}
	}

	/**
	 * Tests the {@link WordParser#parseText(String)} method.
	 */
	public static class ParseTextTest {

		@Test
		public void testEmptyCase() {
			String mytest = "\t + \n @ \t";
			List<String> expect = new ArrayList<String>();
			List<String> actual = WordParser.parseText(mytest);
			Assert.assertEquals(expect, actual);
		}

		@Test
		public void testSimpleCase() {
			String mytest = "A B C";
			List<String> expect = Arrays.asList("a", "b", "c");
			List<String> actual = WordParser.parseText(mytest);
			Assert.assertEquals(expect, actual);
		}

		@Test
		public void testComplexCase() {
			String mytest = "\t heLLo, there! \n Do you have *10* apples?";
			List<String> expect = Arrays.asList("hello", "there", "do",
					"you", "have", "10", "apples");
			List<String> actual = WordParser.parseText(mytest);
			Assert.assertEquals(expect, actual);
		}

	}

	/**
	 * Tests the {@link WordParser#parseFile(java.nio.file.Path) method.
	 */
	public static class ParseFileTest {

		/**
		 * Tests to make sure {@link WordParser#parseFile(Path)} throws
		 * an exception if the file cannot be opened.
		 *
		 * @throws IOException
		 */
		@Test(expected=IOException.class)
		public void testNonExistantFile() throws IOException {
			Path dir = Paths.get(".");
			WordParser.parseFile(dir);
		}

		/**
		 * Tests to make sure an exception is NOT thrown when given a
		 * readable file. Uses a temporary file for testing.
		 */
		@Test
		public void testEmptyFile() throws IOException {
			Path filepath = Files.createTempFile("tmp", ".txt");
			List<String> words = WordParser.parseFile(filepath);

			Assert.assertTrue(words.isEmpty());
			Files.deleteIfExists(filepath);
		}

		/**
		 * Tests a simple file. Files if the results are incorrect, or if
		 * unable to read the test file. Assumes file "seashells.txt" is
		 * located in the root project directory in Eclipse.
		 */
		@Test
		public void testSimpleFile() throws IOException {
			Path filepath = Paths.get("seashells.txt");

			if (!Files.exists(filepath)) {
				Assert.fail("Please make sure you have the file "
						+ "seashells.txt in your root project directory.");
			}

			if (!Files.isReadable(filepath)) {
				Assert.fail("Please make sure that the file seashells.txt "
						+ "is readable.");
			}

			List<String> actual = WordParser.parseFile(filepath);
			List<String> expect = Arrays.asList("sally", "sue", "sells",
					"76", "sea", "shells", "by", "the", "sea", "shore");

			Assert.assertEquals(expect, actual);
		}
	}
}

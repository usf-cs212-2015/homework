import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Tests the {@link ArgumentParser} class. Select "Run" from the
 * menu and select "ArgumentParserTest" to run all of the tests
 * included in this file.
 */
@RunWith(Suite.class)
@SuiteClasses({
	ArgumentParserTest.FlagTest.class,
	ArgumentParserTest.ValueTest.class,
	ArgumentParserTest.ParseTest.class})
public class ArgumentParserTest {

	/**
	 * Tests of the {@link ArgumentParser#isFlag(String)} method.
	 * In Eclipse, select "Run As" from the "Run" menu and select
	 * "FlagTest" to run just these tests and skip the others.
	 */
	public static class FlagTest {
		
		/*
		 * You can select any method in the "JUnit" view pane
		 * to re-run just that method. This helps you debug a
		 * specific test when it is failing. Always focus on 
		 * one test at a time!
		 */
		
		@Test
		public void testFlagLetter() {
			// Test Case: "-a"
			// Test Method: isFlag()
			// Expected Result: true
			Assert.assertTrue(ArgumentParser.isFlag("-a"));
		}

		@Test
		public void testFlagNumber() {
			Assert.assertTrue(ArgumentParser.isFlag("-1"));
		}

		@Test
		public void testFlagWord() {
			Assert.assertTrue(ArgumentParser.isFlag("-hello"));
		}

		@Test
		public void testFlagInvalid() {
			// Test Case: "a-b-c"
			// Test Method: isFlag()
			// Expected Result: false
			Assert.assertFalse(ArgumentParser.isFlag("a-b-c"));
		}

		@Test
		public void testFlagEmpty() {
			Assert.assertFalse(ArgumentParser.isFlag(""));
		}

		@Test
		public void testFlagSpace() {
			Assert.assertFalse(ArgumentParser.isFlag("- "));
		}

		@Test
		public void testFlagDash() {
			Assert.assertFalse(ArgumentParser.isFlag("-"));
		}
	}

	/**
	 * Tests of the {@link ArgumentParser#isValue(String)} method.
	 */
	public static class ValueTest {
		@Test
		public void testValueLetter() {
			Assert.assertTrue(ArgumentParser.isValue("a"));
		}

		@Test
		public void testValueNumber() {
			Assert.assertTrue(ArgumentParser.isValue("1"));
		}

		@Test
		public void testValueWord() {
			Assert.assertTrue(ArgumentParser.isValue("hello"));
		}

		@Test
		public void testValueMixed() {
			Assert.assertTrue(ArgumentParser.isValue("a-b-c"));
		}

		@Test
		public void testValueEmpty() {
			Assert.assertFalse(ArgumentParser.isValue(""));
		}

		@Test
		public void testValueSpace() {
			Assert.assertFalse(ArgumentParser.isValue(" "));
		}

		@Test
		public void testValueDash() {
			Assert.assertFalse(ArgumentParser.isValue("-"));
		}

		@Test
		public void testValueFlag() {
			Assert.assertFalse(ArgumentParser.isValue("-a"));
		}
	}

	/**
	 * Tests of the {@link ArgumentParser#parseArguments(String[])} method.
	 * Do not try these tests until you are passing the other tests first.
	 */
	public static class ParseTest {
		private static final String[] simpleCase = {
			"-a", "ape"
		};

		private static final String[] complexCase = {
			"-a", "ant", "-b", "bat", "cat", "-d", "-e", "elk", "-f"
		};

		@Test
		public void testSimpleCount() {
			// Test Case: "-a", "ape"
			// Test Method: numFlags()
			// Expected Result: 1
			ArgumentParser parser = new ArgumentParser(simpleCase);
			Assert.assertEquals(1, parser.numFlags());
		}

		@Test
		public void testSimpleFlag() {
			ArgumentParser parser = new ArgumentParser(simpleCase);
			Assert.assertTrue(parser.hasFlag("-a"));
		}

		@Test
		public void testSimpleValue() {
			ArgumentParser parser = new ArgumentParser(simpleCase);
			Assert.assertEquals("ape", parser.getValue("-a"));
		}

		@Test
		public void testAllFlags() {
			String[] args = {"-a", "-b", "-c", "-d", "-e"};
			ArgumentParser parser = new ArgumentParser(args);
			Assert.assertEquals(args.length, parser.numFlags());
		}

		@Test
		public void testOneFlag() {
			String[] args = {"-a"};
			ArgumentParser parser = new ArgumentParser(args);
			Assert.assertEquals(args.length, parser.numFlags());
		}

		@Test
		public void testAllValues() {
			String[] args = {"a", "b", "c"};
			ArgumentParser parser = new ArgumentParser(args);
			Assert.assertEquals(0, parser.numFlags());
		}

		@Test
		public void testDuplicateFlags() {
			String[] args = {"-a", "ant", "-a", "ape"};
			ArgumentParser parser = new ArgumentParser(args);
			Assert.assertEquals("ape", parser.getValue("-a"));
		}

		@Test
		public void testEmptyArgs() {
			String[] args = new String[0];
			ArgumentParser parser = new ArgumentParser(args);
			Assert.assertEquals(0, parser.numFlags());
		}

		@Test
		public void testComplexCount() {
			ArgumentParser parser = new ArgumentParser(complexCase);
			Assert.assertEquals(5, parser.numFlags());
		}

		@Test
		public void testComplexLastFlag() {
			ArgumentParser parser = new ArgumentParser(complexCase);
			Assert.assertTrue(parser.hasFlag("-f"));
		}

		@Test
		public void textComplexGetValue() {
			ArgumentParser parser = new ArgumentParser(complexCase);
			Assert.assertEquals("bat", parser.getValue("-b"));
		}

		@Test
		public void testComplexHasValue() {
			ArgumentParser parser = new ArgumentParser(complexCase);
			Assert.assertTrue(parser.hasValue("-e"));
		}

		@Test
		public void testComplexNullValue() {
			ArgumentParser parser = new ArgumentParser(complexCase);
			Assert.assertNull(parser.getValue("-d"));
		}

		@Test
		public void testComplexHasNoFlag() {
			ArgumentParser parser = new ArgumentParser(complexCase);
			Assert.assertFalse(parser.hasFlag("cat"));
		}
	}
}
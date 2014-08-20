import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	ArgumentParserTest.FlagTest.class,
	ArgumentParserTest.ValueTest.class,
	ArgumentParserTest.ParseTest.class})
public class ArgumentParserTest {

	public static class FlagTest {
		@Test
		public void testFlagLetter() {
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

	public static class ParseTest {
		private static final String[] simpleCase = {
			"-a", "ape"
		};

		private static final String[] complexCase = {
			"-a", "ant", "-b", "bat", "cat", "-d", "-e", "elk", "-f"
		};

		@Test
		public void testSimpleCount() {
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

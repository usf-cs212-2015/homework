import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

/**
 * A helper class with several static methods that will help fetch a
 * webpage, strip out all of the HTML, and parse the resulting plain
 * text into words. Meant to be used for the web crawler project.
 *
 * @author Sophie Engle
 * @author CS 212 Software Development
 * @author University of San Francisco
 *
 * @see HTMLCleaner
 * @see HTMLCleanerTest
 */
public class HTMLCleanerTest {

	/*
	 * TEST HTML ENTITIES
	 */

	@Test
	public void testEntities1() {
		String test = "2010&ndash;2011";
		String expected = "20102011";
		String actual = HTMLCleaner.stripEntities(test);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testEntities2() {
		String test = "2010&#8211;2011";
		String expected = "20102011";
		String actual = HTMLCleaner.stripEntities(test);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testEntities3() {
		String test = "2010&#x2013;2011";
		String expected = "20102011";
		String actual = HTMLCleaner.stripEntities(test);

		Assert.assertEquals(expected, actual);
	}

	/*
	 * TEST HTML TAGS
	 */

	@Test
	public void testTags1() {
		String test = "<b>hello</b> world!";
		String expected = "hello world!";
		String actual = HTMLCleaner.stripTags(test);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testTags2() {
		String test = "<b>hello\n</b> world!";
		String expected = "hello\n world!";
		String actual = HTMLCleaner.stripTags(test);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testTags3() {
		String test = "<a \n name=toc>table of contents</a>";
		String expected = "table of contents";
		String actual = HTMLCleaner.stripTags(test);

		Assert.assertEquals(expected, actual);
	}

	/*
	 * TEST HTML ELEMENTS
	 */

	@Test
	public void testElements1() {
		String test = "<style type=\"text/css\">body { font-size: 10pt; }</style>";
		String expected = "";
		String actual = HTMLCleaner.stripElement("style", test);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testElements2() {
		String test = "<style type=\"text/css\">\nbody { font-size: 10pt; }\n</style>";
		String expected = "";
		String actual = HTMLCleaner.stripElement("style", test);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testElements3() {
		String test = "<style \n type=\"text/css\">\nbody { font-size: 10pt; }\n</style>";
		String expected = "";
		String actual = HTMLCleaner.stripElement("style", test);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testElements4() {
		String test = "a<test>b</test>c<test>d</test>e";
		String expected = "ace";
		String actual = HTMLCleaner.stripElement("test", test);

		Assert.assertEquals(expected, actual);
	}

	/*
	 * TEST OTHERS
	 */

	@Test
	public void testClean() {
		StringBuilder html = new StringBuilder();
		html.append("<!DOCTYPE html>\n");
		html.append("<html>\n");
		html.append("<head>\n");
		html.append("    <meta charset=\"utf-8\">\n");
		html.append("    <script type=\"text/javascript\" src=\"d3.v3.js\"></script>\n");
		html.append("    <style type=\"text/css\">\n");
		html.append("    body {\n");
		html.append("        font-size: 10pt;\n");
		html.append("        font-family: sans-serif;\n");
		html.append("    }\n");
		html.append("    </style>\n");
		html.append("</head>\n");
		html.append("<body>\n");
		html.append("Hello, world! &copy;2013\n");
		html.append("</body>\n");
		html.append("</html>\n");

		String expected = "Hello, world! 2013";
		String actual = HTMLCleaner.cleanHTML(html.toString());

		// note the trim to remove the blank lines
		Assert.assertEquals(expected, actual.trim());
	}

	@Test
	public void testParse1() {
		String url = "http://www.cs.usfca.edu/~sjengle/crawltest/a.html";
		String[] expected = new String[] { "animals", "that", "start", "with",
				"a","allosaurus", "ant", "albatross", "amoeba", "abalone",
				"arachnid", "anaconda", "aardvark", "angora", "aphid",
				"addax", "aardvarks", "adder" };
		ArrayList<String> actual = HTMLCleaner.fetchWords(url);
		Assert.assertArrayEquals(expected, actual.toArray(new String[0]));
	}

	@Test
	public void testParse2() {
		String url = "http://www.cs.usfca.edu/~sjengle/crawltest/parsetest.html";
		String[] expected = new String[] { "pangrams", "the", "quick", "brown",
				"fox", "jumps", "over", "a", "lazy", "dog", "djs", "flock",
				"by", "when", "mtv", "ax", "quiz", "prog", "junk", "mtv",
				"quiz", "graced", "by", "fox", "whelps", "bawds", "jog",
				"flick", "quartz", "vex", "nymphs", "waltz", "bad", "nymph",
				"for", "quick", "jigs", "vex", "fox", "nymphs", "grab",
				"quickjived", "waltz", "painful", "zombies", "quickly",
				"watch", "a", "jinxed", "graveyard", "brick", "quiz", "whangs",
				"jumpy", "veldt", "fox", "bright", "vixens", "jump", "dozy",
				"fowl", "quack", "quick", "wafting", "zephyrs", "vex", "bold",
				"jim", "quick", "zephyrs", "blow", "vexing", "daft", "jim",
				"how", "quickly", "daft", "jumping", "zebras", "vex", "cozy",
				"lummox", "gives", "smart", "squid", "who", "asks", "for",
				"job", "pen", "quick", "baz", "get", "my", "woven", "flax",
				"jodhpurs", "now", "fax", "quiz", "jack", "my", "brave",
				"ghost", "pled", "five", "quacking", "zephyrs", "jolt", "my",
				"wax", "bed", "cozy", "sphinx", "waves", "quart", "jug", "of",
				"bad", "milk", "a", "very", "bad", "quack", "might", "jinx",
				"zippy", "fowls", "few", "quips", "galvanized", "the", "mock",
				"jury", "box", "quick", "brown", "dogs", "jump", "over", "the",
				"lazy", "fox", "the", "jay", "pig", "fox", "zebra", "and",
				"my", "wolves", "quack", "how", "razorbackjumping", "frogs",
				"can", "level", "six", "piqued", "gymnasts" };
		ArrayList<String> actual = HTMLCleaner.fetchWords(url);
		Assert.assertArrayEquals(actual.toString(), expected, actual.toArray(new String[0]));
	}
}

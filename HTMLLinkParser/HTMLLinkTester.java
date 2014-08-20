
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the {@link HTMLLinkParser} class. All tests must pass for a 100% grade.
 *
 * @author Sophie Engle
 * @author Department of Computer Science
 * @author University of San Francisco
 */
public class HTMLLinkTester {

	@Test
	public void simpleLink() {
		String test = "<a href=\"http://www.usfca.edu/\">";
		String expected = "http://www.usfca.edu/";
		testText(test, expected);
	}

	@Test
	public void complexLink() {
		String test = "<a href=\"http://docs.python.org/library/string.html?highlight=string#module-string\">";
		String expected = "http://docs.python.org/library/string.html?highlight=string#module-string";
		testText(test, expected);
	}

	@Test
	public void allUppercase() {
		String test = "<A HREF=\"HTTP://WWW.USFCA.EDU\">";
		String expected = "HTTP://WWW.USFCA.EDU";
		testText(test, expected);
	}

	@Test
	public void mixedCase() {
		String test = "<A hREf=\"http://www.usfca.edu\">";
		String expected = "http://www.usfca.edu";
		testText(test, expected);
	}

	@Test
	public void withSpaces() {
		String test = "<a   href      = \"http://www.usfca.edu\"  >";
		String expected = "http://www.usfca.edu";
		testText(test, expected);
	}

	@Test
	public void nameFirst() {
		String test = "<a name=\"home\" href=\"index.html\">";
		String expected = "index.html";
		testText(test, expected);
	}

	@Test
	public void nameLast() {
		String test = "<a href=\"index.html\" name=\"home\">";
		String expected = "index.html";
		testText(test, expected);
	}

	@Test
	public void multipleAttributes() {
		String test = "<a name=\"home\" target=\"_top\" href=\"index.html\" id=\"home\" accesskey=\"A\">";
		String expected = "index.html";
		testText(test, expected);
	}

	@Test
	public void withNewline() {
		String test = "<a href = \n \"http://www.usfca.edu\">";
		String expected = "http://www.usfca.edu";
		testText(test, expected);
	}

	@Test
	public void manyNewlines() {
		String test = "<a\n\nhref\n=\n\"http://www.usfca.edu\"\n>";
		String expected = "http://www.usfca.edu";
		testText(test, expected);
	}

	@Test
	public void complexExample() {
		String test = "<A\n      HrEF = \"index.html\" naMe=home    >";
		String expected = "index.html";
		testText(test, expected);
	}

	@Test
	public void noHref() {
		String test = "<a name = \"home\">";
		String[] expected = new String[0];
		testText(test, expected);
	}

	@Test
	public void noAnchor() {
		String test = "<h1>Home</h1>";
		String[] expected = new String[0];
		testText(test, expected);
	}

	@Test
	public void noLink() {
		String test = "<a name=href>The href = \"link\" attribute is useful.</a>";
		String[] expected = new String[0];
		testText(test, expected);
	}

	@Test
	public void linkHref() {
		String test = "<link href=\"style.css\" type=\"text/css\"></link>";
		String[] expected = new String[0];
		testText(test, expected);
	}

	@Test
	public void noTag() {
		String test = "<p>The a href=\"http://www.google.com\" attribute is often used in HTML.</p>";
		String[] expected = new String[0];
		testText(test, expected);
	}

	@Test
	public void htmlSnippet() {
		String test = "<p><a href=\"http://www.usfca.edu\">USFCA</a> is in San Francisco.</p>";
		String expected = "http://www.usfca.edu";
		testText(test, expected);
	}

	@Test
	public void multipleLinks() {
		String test = "<h1>About</h1>\n" +
				"<p>The <a href=\"http://www.cs.usfca.edu/\">Department " +
				"of Computer Science</a> offers two Masters degrees at " +
				"<a href=\"http://www.usfca.edu\">University of San " +
				"Francisco</a>.</p>\n" +
				"<p>Find out more about those degrees at <a href=\"" +
				"http://cs.usfca.edu/grad.html\">http://cs.usfca.edu/" +
				"grad.html</a>.</p>";

		String[] expected = new String[] {
				"http://www.cs.usfca.edu/",
				"http://www.usfca.edu",
				"http://cs.usfca.edu/grad.html" };

		testText(test, expected);
	}

	/**
	 * Tests whether running the {@link HTMLLinkParser} on the provided
	 * text generates the expected results.
	 *
	 * @param text - valid HTML code, with quoted attributes and URL encoded links
	 * @param expected - array of expected links (order matters)
	 */
	private static void testText(String text, String[] expected) {
		ArrayList<String> results = HTMLLinkParser.listLinks(text);

		String debug = String.format("Text: %s, Expected: %s, Got: %s",
				text, Arrays.toString(expected), results);

		Assert.assertArrayEquals(debug, expected, results.toArray(new String[0]));
	}

	/**
	 * @see #testText(String, String[])
	 */
	private static void testText(String text, String expected) {
		testText(text, new String[] {expected});
	}
}

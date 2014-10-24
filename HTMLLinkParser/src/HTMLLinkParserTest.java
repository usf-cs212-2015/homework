
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Tests the {@link HTMLLinkParser} class. All tests must pass for a 100% grade.
 * You must fill in the tests in {@link HTMLLinkParserExtraTest}.
 *
 * @see HTMLLinkParser
 * @see HTMLLinkParserTest
 * @see HTMLLinkParserExtraTest
 */
@RunWith(Suite.class)
@SuiteClasses({
    HTMLLinkParserTest.ProvidedTests.class,
    HTMLLinkParserExtraTest.class
})
public class HTMLLinkParserTest {

    public static class ProvidedTests {

        @Test
        public void simpleLink() {
            String test = "<a href=\"http://www.usfca.edu/\">";
            String link = "http://www.usfca.edu/";

            ArrayList<String> expected = new ArrayList<>();
            expected.add(link);

            ArrayList<String> actual = HTMLLinkParser.listLinks(test);

            assertEquals(test, expected, actual);
        }

        @Test
        public void complexLink() {
            String test = "<a href=\"http://docs.python.org/library/string.html?highlight=string#module-string\">";
            String link = "http://docs.python.org/library/string.html?highlight=string#module-string";

            ArrayList<String> expected = new ArrayList<>();
            expected.add(link);

            ArrayList<String> actual = HTMLLinkParser.listLinks(test);

            assertEquals(test, expected, actual);
        }

        @Test
        public void allUppercase() {
            String test = "<A HREF=\"HTTP://WWW.USFCA.EDU\">";
            String link = "HTTP://WWW.USFCA.EDU";

            ArrayList<String> expected = new ArrayList<>();
            expected.add(link);

            ArrayList<String> actual = HTMLLinkParser.listLinks(test);

            assertEquals(test, expected, actual);
        }

        @Test
        public void mixedCase() {
            String test = "<A hREf=\"http://www.usfca.edu\">";
            String link = "http://www.usfca.edu";

            ArrayList<String> expected = new ArrayList<>();
            expected.add(link);

            ArrayList<String> actual = HTMLLinkParser.listLinks(test);

            assertEquals(test, expected, actual);
        }

        @Test
        public void withSpaces() {
            String test = "<a   href      = \"http://www.usfca.edu\"  >";
            String link = "http://www.usfca.edu";

            ArrayList<String> expected = new ArrayList<>();
            expected.add(link);

            ArrayList<String> actual = HTMLLinkParser.listLinks(test);

            assertEquals(test, expected, actual);
        }

        @Test
        public void nameFirst() {
            String test = "<a name=\"home\" href=\"index.html\">";
            String link = "index.html";

            ArrayList<String> expected = new ArrayList<>();
            expected.add(link);

            ArrayList<String> actual = HTMLLinkParser.listLinks(test);

            assertEquals(test, expected, actual);
        }

        @Test
        public void nameLast() {
            String test = "<a href=\"index.html\" name=\"home\">";
            String link = "index.html";

            ArrayList<String> expected = new ArrayList<>();
            expected.add(link);

            ArrayList<String> actual = HTMLLinkParser.listLinks(test);

            assertEquals(test, expected, actual);
        }

        @Test
        public void multipleAttributes() {
            String test = "<a name=\"home\" target=\"_top\" href=\"index.html\" id=\"home\" accesskey=\"A\">";
            String link = "index.html";

            ArrayList<String> expected = new ArrayList<>();
            expected.add(link);

            ArrayList<String> actual = HTMLLinkParser.listLinks(test);

            assertEquals(test, expected, actual);
        }

        @Test
        public void withNewline() {
            String test = "<a href = \n \"http://www.usfca.edu\">";
            String link = "http://www.usfca.edu";

            ArrayList<String> expected = new ArrayList<>();
            expected.add(link);

            ArrayList<String> actual = HTMLLinkParser.listLinks(test);

            assertEquals(test, expected, actual);
        }

        @Test
        public void manyNewlines() {
            String test = "<a\n\nhref\n=\n\"http://www.usfca.edu\"\n>";
            String link = "http://www.usfca.edu";

            ArrayList<String> expected = new ArrayList<>();
            expected.add(link);

            ArrayList<String> actual = HTMLLinkParser.listLinks(test);

            assertEquals(test, expected, actual);
        }

        @Test
        public void complexExample() {
            String test = "<A\n      HrEF = \"index.html\" naMe=home    >";
            String link = "index.html";

            ArrayList<String> expected = new ArrayList<>();
            expected.add(link);

            ArrayList<String> actual = HTMLLinkParser.listLinks(test);

            assertEquals(test, expected, actual);
        }

        	@Test
        	public void noHref() {
        		String test = "<a name = \"home\">";

        		ArrayList<String> expected = new ArrayList<>();
        		ArrayList<String> actual = HTMLLinkParser.listLinks(test);

        		assertEquals(test, expected, actual);
        	}

        	@Test
        	public void noAnchor() {
        		String test = "<h1>Home</h1>";

        		ArrayList<String> expected = new ArrayList<>();
        		ArrayList<String> actual = HTMLLinkParser.listLinks(test);

        		assertEquals(test, expected, actual);
        	}

        	@Test
        	public void noLink() {
        		String test = "<a name=href>The href = \"link\" attribute is useful.</a>";

        		ArrayList<String> expected = new ArrayList<>();
        		ArrayList<String> actual = HTMLLinkParser.listLinks(test);

        		assertEquals(test, expected, actual);
        	}

        	@Test
        	public void linkHref() {
        		String test = "<link href=\"style.css\" type=\"text/css\"></link>";

        		ArrayList<String> expected = new ArrayList<>();
        		ArrayList<String> actual = HTMLLinkParser.listLinks(test);

        		assertEquals(test, expected, actual);
        	}

        	@Test
        	public void noTag() {
        		String test = "<p>The a href=\"http://www.google.com\" attribute is often used in HTML.</p>";

        		ArrayList<String> expected = new ArrayList<>();
        		ArrayList<String> actual = HTMLLinkParser.listLinks(test);

        		assertEquals(test, expected, actual);
        	}

        	@Test
        	public void htmlSnippet() {
        		String test = "<p><a href=\"http://www.usfca.edu\">USFCA</a> is in San Francisco.</p>";
        		String link = "http://www.usfca.edu";

        		ArrayList<String> expected = new ArrayList<>();
        		expected.add(link);

        		ArrayList<String> actual = HTMLLinkParser.listLinks(test);

        		assertEquals(test, expected, actual);
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

        		ArrayList<String> expected = new ArrayList<>();
        		Collections.addAll(expected,
        		        "http://www.cs.usfca.edu/",
        		        "http://www.usfca.edu",
        		        "http://cs.usfca.edu/grad.html" );

        		ArrayList<String> actual = HTMLLinkParser.listLinks(test);

        		assertEquals(test, expected, actual);
        	}
    }
}

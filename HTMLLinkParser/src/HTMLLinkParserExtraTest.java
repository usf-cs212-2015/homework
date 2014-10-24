import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

/**
 * You must fill in 5 tests in this class according to the documentation
 * provided. This involves specifying a test case and the expected output.
 * The rest of the test code as already been provided for you.
 *
 * <p><strong>
 * You cannot replicate any of the tests already provided for you in
 * {@link HTMLLinkParserTest}! You must provide new and unique test cases.
 * </p></strong>
 *
 * @see HTMLLinkParser
 * @see HTMLLinkParserTest
 * @see HTMLLinkParserExtraTest
 */
public class HTMLLinkParserExtraTest {

    /**
     * Tests a simple html snippet (with 1 to 2 tags) that contains no
     * links (a link being the text specified as the "href" attribute of
     * an anchor "a" tag).
     */
    @Test
    public void testSimpleHTMLNoLinks() {
        // TODO Fill in test case.
        String test = null;

        ArrayList<String> expected = new ArrayList<String>();
        ArrayList<String> actual = HTMLLinkParser.listLinks(test);

        assertEquals(expected, actual);
    }

    /**
     * Tests a simple html snippet (with 1 to 2 tags) that contains one
     * link (a link being the text specified as the "href" attribute of
     * an anchor "a" tag).
     */
    @Test
    public void testSimpleHTMLOneLink() {
        // TODO Fill in test case.
        String test = null;

        // TODO Fill in expected link.
        String link = null;

        ArrayList<String> expected = new ArrayList<String>();
        expected.add(link);

        ArrayList<String> actual = HTMLLinkParser.listLinks(test);

        assertEquals(expected, actual);
    }

    /**
     * Tests a simple html snippet (with 1 to 2 tags) that contains two
     * links (a link being the text specified as the "href" attribute of
     * an anchor "a" tag).
     */
    @Test
    public void testSimpleHTMLTwoLinks() {
        // TODO Fill in test case.
        String test = null;

        // TODO Fill in expected links.
        String link1 = null;
        String link2 = null;

        ArrayList<String> expected = new ArrayList<String>();
        expected.add(link1);
        expected.add(link2);

        ArrayList<String> actual = HTMLLinkParser.listLinks(test);

        assertEquals(expected, actual);
    }

    /**
     * Tests a complex html snippet (with 3 to 5 tags and newlines) that
     * contains no links (a link being the text specified as the "href"
     * attribute of an anchor "a" tag).
     */
    @Test
    public void testComplexHTMLNoLinks() {
        // TODO Fill in test case.
        String test = null;

        ArrayList<String> expected = new ArrayList<String>();
        ArrayList<String> actual = HTMLLinkParser.listLinks(test);

        assertEquals(expected, actual);
    }

    /**
     * Tests a complex html snippet (with 3 to 5 tags and newlines) that
     * contains two links (a link being the text specified as the "href"
     * attribute of an anchor "a" tag).
     */
    @Test
    public void testComplexHTMLTwoLinks() {
        // TODO Fill in test case.
        String test = null;

        // TODO Fill in expected links.
        String link1 = null;
        String link2 = null;

        ArrayList<String> expected = new ArrayList<String>();
        expected.add(link1);
        expected.add(link2);

        ArrayList<String> actual = HTMLLinkParser.listLinks(test);

        assertEquals(expected, actual);
    }
}

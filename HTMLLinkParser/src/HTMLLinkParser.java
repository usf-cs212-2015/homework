import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * For this homework assignment, you must create a regular expression that
 * is able to parse links from HTML. Your code may assume the HTML is valid,
 * and all attributes are properly quoted and URL encoded.
 *
 * <p>
 * See the following link for details on the HTML Anchor tag:
 * <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/a">
 * https://developer.mozilla.org/en-US/docs/Web/HTML/Element/a
 * </a>
 *
 * You must ALSO fill in 5 unit tests in {@link HTMLLinkParserExtraTest} that
 * you create yourself. This involves deciding on a test case and the
 * expected output. All other parts of each test have been provided.
 *
 * @see HTMLLinkParser
 * @see HTMLLinkParserTest
 * @see HTMLLinkParserExtraTest
 */
public class HTMLLinkParser {

	/**
	 * The regular expression used to parse the HTML for links.
	 *
	 * TODO: FILL THIS IN
	 */
	public static final String REGEX = null;

	/**
	 * The group in the regular expression that captures the raw link. This
	 * will usually be 1, depending on your specific regex.
	 *
	 * TODO: FILL THIS IN
	 */
	public static final int GROUP = 1;

	/**
	 * Parses the provided text for HTML links. You should not need to modify
	 * this method.
	 *
	 * @param html - valid HTML code, with quoted attributes and URL encoded links
	 * @return list of links found in HTML code
	 */
	public static ArrayList<String> listLinks(String html) {
		// list to store links
		ArrayList<String> links = new ArrayList<String>();

		// compile string into regular expression
		Pattern p = Pattern.compile(REGEX);

		// match provided text against regular expression
		Matcher m = p.matcher(html);

		// loop through every match found in text
		while(m.find()) {
			// add the appropriate group from regular expression to list
			links.add(m.group(GROUP));
		}

		return links;
	}
}

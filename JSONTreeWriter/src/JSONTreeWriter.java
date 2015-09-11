import java.io.IOException;
import java.nio.file.Path;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Utility class that outputs various Tree structures as JSON objects or arrays
 * to file. Designed to demonstrate basic file processing and exception
 * handling, and the JSON format.
 * 
 * You are welcome to add additional helper methods to this class. If you go
 * about this in a general way, there will be very little repeated copy/pasted
 * code in this class.
 */
public class JSONTreeWriter {

    /**
     * Helper method to indent several times by 2 spaces each time. For example,
     * indent(0) will return an empty string, indent(1) will return 2 spaces,
     * and indent(2) will return 4 spaces.
     * 
     * <p>
     * <em>Using this method is optional!</em>
     * </p>
     * 
     * @param times
     * @return
     * @throws IOException
     */
    public static String indent(int times) throws IOException {
        return times > 0 ? String.format("%" + (times * 2) + "s", " ") : "";
    }

    /**
     * Helper method to quote text for output. This requires escaping the
     * quotation mark " as \" for use in Strings. For example:
     * 
     * <pre>
     * String text = "hello world";
     * System.out.println(text); // output: hello world
     * System.out.println(quote(text)); // output: "hello world"
     * </pre>
     * 
     * @param text
     *            input to surround with quotation marks
     * @return quoted text
     */
    public static String quote(String text) {
        return "\"" + text + "\"";
    }

    /**
     * Writes the elements as a JSON object to the specified output path using
     * the "UTF-8" character set. The output is in a "pretty" format with 2
     * spaces per indent level.
     * 
     * <pre>
     * {
     *   "key1": value1,
     *   "key2": value2
     * }
     * </pre>
     * 
     * <p>
     * Note that there is not a trailing space after the second value, the key
     * should be in quotes, and this method should NOT throw an exception.
     * </p>
     * 
     * @param output
     *            file to write
     * @param elements
     *            to write as a JSON object
     * @return true if there were no problems or exceptions
     */
    public static boolean writeObject(Path output, TreeMap<String, Integer> elements) {
        boolean status = false;

        // TODO Fill in. Write to file efficiently (consider your memory usage).
        // Do not throw any exceptions!

        return status;
    }

    /**
     * Writes the elements as a JSON array to the specified output path using
     * the "UTF-8" character set. The output is in a "pretty" format with 2
     * spaces per indent level.
     * 
     * <pre>
     * [
     *   value1,
     *   value2
     * ]
     * </pre>
     * 
     * <p>
     * Note that there is not a trailing space after the second value, and this
     * method should NOT throw an exception.
     * </p>
     * 
     * @param output
     *            file to write
     * @param elements
     *            to write as a JSON array
     * @return true if there were no problems or exceptions
     */
    public static boolean writeArray(Path output, TreeSet<Integer> elements) {
        boolean status = false;

        // TODO Fill in. Write to file efficiently (consider your memory usage).
        // Do not throw any exceptions!

        return status;
    }

    /**
     * Writes the elements as a JSON object with nested array values to the
     * specified output path using the "UTF-8" character set. The output is in a
     * "pretty" format with 2 spaces per indent level.
     * 
     * <pre>
     * {
     *   "key1": [
     *     value1,
     *     value2
     *   ],
     *   "key2": [
     *     value3
     *   ]
     * }
     * </pre>
     * 
     * <p>
     * Note that there is not a trailing space after the second value, the key
     * should be in quotes, and this method should NOT throw an exception.
     * </p>
     * 
     * @param output
     *            file to write
     * @param elements
     *            to write as a JSON array
     * @return true if there were no problems or exceptions
     */
    public static boolean writeNestedObject(Path output, 
            TreeMap<String, TreeSet<Integer>> elements) {
        boolean status = false;

        // TODO Fill in. Write to file efficiently (consider your memory usage).
        // Do not throw any exceptions!

        return status;
    }

    // TODO Feel free to add private static helper methods here (optional)! 

}

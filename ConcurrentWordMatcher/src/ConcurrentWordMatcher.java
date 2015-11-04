import java.nio.file.Path;
import java.util.Map;

/**
 * A multithreaded word matches. Uses a work queue to handle multithreading.
 * Accumulates matches to specified regular expressions until the underlying
 * work queue is shutdown.
 *
 * @see TextFileWordMatcher
 */
public class ConcurrentWordMatcher {

    /** Work queue used to handle multithreading for this class. */
    private final WorkQueue workers;

    /** Stores a mapping between regex and number of matches found for that regex. */
    private final Map<String, Integer> matches;

    // TODO Add additional members as necessary here.

    /**
     * Initializes this multithreaded word counter. The underlying work queue
     * will be active until {@link #shutdown()} is called.
     */
    public ConcurrentWordMatcher() {
        workers = null; // TODO Fix initialization
        matches = null; // TODO Fix initialization
        
        // TODO Initialize additional members properly here.
    }

    /**
     * Counts the number of words that match the provided regular expression
     * within all of the text files found at the provided path.
     *
     * @param path   path to search (can be a directory or text file)
     * @param regex  regular expression to match words against
     *
     * @see TextFileWordMatcher#countWords(Path, String)
     */
    public void parseTextFiles(Path path, String regex) {
        // TODO Fill this in. Create one "task" per text file found.
    }

    /**
     * Returns the number of matches found so far for the provided regular expression.
     * Unless there are one or more calls to {@link #parseTextFiles(Path, String)},
     * this will always return 0.
     *
     * @param regex  regular expression that was matched against
     * @return number of matches found by prior calls to {@link #parseTextFiles(Path, String)}
     *
     * @see #parseTextFiles(Path, String)
     * @see Map#getOrDefault(Object, Object)
     */
    public synchronized int getCount(String regex) {
        // TODO Fill this in.
        // TODO Make sure there is no pending work before returning the value!
        
        return -1; // TODO Fix return
    }

    /**
     * Shutsdown the work queue after all pending work is finished. After this
     * point, all additional calls to {@link #parseTextFiles(Path, String)} will
     * no longer work.
     */
    public synchronized void shutdown() {
        // TODO Fill this in.
        // TODO Make sure there is no pending work before shutting down!
    }

    // TODO Add additional methods and inner classes here as needed.
}

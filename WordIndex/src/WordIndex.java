import java.util.Map;
import java.util.Set;


public class WordIndex {

    /**
     * Stores a mapping of words to the positions those words were found.
     */
    private Map<String, Set<Integer>> index;

    /**
     * Properly initializes the index. Choose the fastest data structures
     * available, as sorting is not a requirement of this index.
     */
    public WordIndex() {
    	// TODO
        index = null;
    }

    /**
     * Properly adds a word and position to the index. Must initialize inner
     * data structure if necessary. Make sure you consider how to handle
     * duplicates (duplicate words, and words with duplicate positions).
     *
     * @param word
     *            - word to add to index
     * @param position
     *            - position word was found
     * @return true if this was a unique entry,
     *         false if no changes were made to the index
     */
    public boolean add(String word, int position) {
    	// TODO
        return false;
    }

    /**
     * Returns the number of times a word was found (i.e. the number of
     * positions associated with a word in the index).
     *
     * @param word - word to look for
     * @return number of times word was found
     */
    public int count(String word) {
        // TODO
    	return -1;
    }

    /**
     * Returns the total number of words stored in the index.
     * @return number of words
     */
    public int words() {
        // TODO
    	return -1;
    }

    /**
     * Tests whether the index contains the specified word.
     * @param word - word to look for
     * @return true if the word is stored in the index
     */
    public boolean contains(String word) {
        // TODO
    	return false;
    }

    /**
     * Safely returns the set of positions for a specified word (or an
     * empty set if the word is not found). Be wary of directly returning
     * a reference to your private mutable data!
     *
     * @param word - word to look for
     * @return set of positions associated with word (will be empty if
     *         word was not found)
     */
    public Set<Integer> positions(String word) {
        // TODO
    	return null;
    }

    /**
     * Returns a string representation of this index for debugging.
     */
    @Override
    public String toString() {
    	// THIS METHOD IS PROVIDED FOR YOU
        return index.toString();
    }
}

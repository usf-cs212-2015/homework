import java.util.*;

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
    	// TODO Fix initialization
        index = null;
    }

    /**
     * Cleans a word by converting it to lowercase and removing any whitespace
     * at the start or end of the word.
     * 
     * @param word
     *            word to clean
     * @return cleaned word
     */
    public static String clean(String word) {
		// TODO Fill this in and fix return statement.    	
        return null;
    }

    /**
     * Properly adds a word and position to the index. Must initialize inner
     * data structure if necessary. Make sure you consider how to handle
     * duplicates (duplicate words, and words with duplicate positions), and how
     * to handle words with mixed case and extra spaces.
     *
     * @param word
     *            word to add to index
     * @param position
     *            position word was found
     * @return true if this was a unique entry, false if no changes were made to
     *         the index
     */
    public boolean add(String word, int position) {
		// TODO Fill this in and fix return statement.
    	return false;
    }

    /**
     * Adds all elements sequentially from array into word index. Assumes the
     * starting position is 1. Consider how to handle duplicates and words with
     * mixed case and extra spaces. Use the other methods in this class as
     * appropriate!
     * 
     * @param words
     *            array of words to add to index
     */
    public void addAll(String[] words) {
		// TODO Fill this in.    
    }

    /**
     * Returns the number of times a word was found (i.e. the number of
     * positions associated with a word in the index). Consider how words are
     * converted before being stored in your index!
     *
     * @param word
     *            word to look for
     * @return number of times word was found
     */
    public int count(String word) {
		// TODO Fill this in and fix return statement.
    	return -1;
    }

    /**
     * Returns the total number of words stored in the index.
     * 
     * @return number of words
     */
    public int words() {
		// TODO Fill this in and fix return statement.
    	return -1;
    }

    /**
     * Tests whether the index contains the specified word. Consider how you are
     * storing words in your index!
     * 
     * @param word
     *            word to look for
     * @return true if the word is stored in the index
     */
    public boolean contains(String word) {
		// TODO Fill this in and fix return statement.
    	return false;
    }

    /**
     * Safely returns the set of positions for a specified word (or an empty set
     * if the word is not found). Be wary of directly returning a reference to
     * your private mutable data, and consider how you are storing words in your
     * index!
     *
     * @param word
     *            word to look for
     * @return set of positions associated with word (will be empty if word was
     *         not found)
     */
    public Set<Integer> positions(String word) {
		// TODO Fill this in and fix return statement.
    	return null;
    }

    /**
     * Returns a string representation of this index for debugging.
     */
    @Override
    public String toString() {
        return index.toString();
    }
}

import java.util.Collections;
import java.util.LinkedList;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A thread-safe list that always stores elements in sorted order.
 */
public class AlwaysSortedList {

	/*
	 * You may add additional members, but you may NOT remove or comment out
	 * the members below. This means you must get Lo4j4 working.
	 */

	private LinkedList<String> list;
	public static final Logger logger = LogManager.getLogger();

	public AlwaysSortedList() {
		list = new LinkedList<String>();
	}

	/**
	 * Safely adds an element to the list and then calls
	 * {@link Collections#sort(java.util.List)} on the list to maintain the
	 * sorted order. Also wakes up any threads waiting for a non-empty list.
	 *
	 * @param element - element to add to the list
	 */
	public void add(String element) {
		// TODO: Fill this in.
		logger.log(Level.DEBUG, "Added {} to the list.", element);
	}

	/**
	 * Safely returns and removes the first element of the list using
	 * {@link LinkedList#pop()}. If the list is empty, will wait until there
	 * is an element to pop from the list.
	 *
	 * @return
	 */
	public String pop() {
		String element = null;

		// TODO: Fill this in! Use proper exception handling.
		
		logger.log(Level.DEBUG, "Popped {} from the list.", element);
		return element;
	}

	/**
	 * Safely returns the list as a String using {@link LinkedList#toString()}.
	 */
	@Override
	public String toString() {
		// TODO: Fill this in and change return value as necessary.
		return null;
	}

	/**
	 * Safely returns the size of the list using {@link LinkedList#size()}.
	 * @return size of list
	 */
	public int size() {
		// TODO: Fill this in and change return value as necessary.
		return -1;
	}
}

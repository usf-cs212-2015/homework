import java.nio.file.Path;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Maintains a thread-safe set of paths. Will return a sorted copy of paths.
 * 
 * This class is primarily meant to demonstrate how to use a lock class, and
 * may not be an example of good class design outside of this context.
 */
public class ThreadSafePathSet {

	private Set<Path> paths;
	private MultiReaderLock lock;

	public ThreadSafePathSet() {
		paths = new HashSet<Path>();
		lock = new MultiReaderLock();
	}

	/**
	 * Adds a single path.
	 * 
	 * @param path to add
	 */
	public void add(Path path) {
		// TODO: Add proper locking.
		paths.add(path);
	}

	/**
	 * Adds multiple paths.
	 * 
	 * @param paths to be added
	 */
	public void addAll(Collection<Path> paths) {
		// TODO: Add proper locking.
		this.paths.addAll(paths);
	}

	/**
	 * Returns the sorted copy of paths as a String.
	 */
	@Override
	public String toString() {
		return sortedCopy().toString();
	}

	/**
	 * Returns a sorted copy of the paths.
	 * @return sorted path set
	 */
	public Set<Path> sortedCopy() {
		// TODO: Add proper locking.
		
		Set<Path> result = new TreeSet<Path>();
		
		for (Path path : paths) {
			result.add(path);
		}

		return result;
	}
}

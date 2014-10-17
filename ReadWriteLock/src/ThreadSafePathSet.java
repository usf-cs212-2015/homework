import java.nio.file.Path;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * A thread-safe set of paths. Used to demonstrate how to
 * take advantage of a read/write lock.
 */
public class ThreadSafePathSet {

    /** Unsorted set of paths. */
    private Set<Path> paths;

    /** Used to protect concurrent access to the paths set. */
    private ReadWriteLock lock;

    /**
     * Initializes an empty set of paths.
     */
    public ThreadSafePathSet() {
        paths = new HashSet<Path>();
        lock = new ReadWriteLock();
    }

    /**
     * Safely adds a path to the set.
     *
     * @param path - path to add
     * @return true if this set did not already contain the specified element
     */
    public boolean add(Path path) {
        // TODO: Lock properly
        boolean changed = paths.add(path);
        return changed;
    }

    /**
     * Safely adds the collection of paths to the set.
     *
     * @param paths
     * @return true if this set changed as a result of the call
     */
    public boolean addAll(Collection<Path> paths) {
        // TODO: Lock properly
        boolean changed = this.paths.addAll(paths);
        return changed;
    }

    @Override
    public String toString() {
        return sortedCopy().toString();
    }

    /**
     * Safely returns a sorted copy of this set.
     *
     * @return sorted copy of the path set
     */
    public Set<Path> sortedCopy() {
        // TODO: Lock properly
        Set<Path> result = new TreeSet<Path>();
        result.addAll(paths);
        return result;
    }
}

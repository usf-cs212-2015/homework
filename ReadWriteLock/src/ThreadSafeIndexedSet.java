/**
 * A thread-safe version of {@link IndexedSet} using a read/write lock.
 *
 * @param <E> element type
 * @see IndexedSet
 * @see ReadWriteLock
 */
public class ThreadSafeIndexedSet<E> extends IndexedSet<E> {

    private ReadWriteLock lock;

    public ThreadSafeIndexedSet() {
        this(false);
    }

    public ThreadSafeIndexedSet(boolean sorted) {
        super(sorted);
        lock = new ReadWriteLock();
    }

    // TODO Make this class thread-safe using a ReadWriteLock object and overriding the necessary methods.
}

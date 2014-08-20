import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;


public class ThreadSafePathSetTester {

	/**
	 * This creates (in a single threaded way) a TreeSet to be
	 * used as the expected output for these tests.
	 *
	 * @param max - number passed to workers
	 * @return expected output
	 */
	private TreeSet<Path> expected(int max) {
		TreeSet<Path> paths = new TreeSet<Path>();

		for (int i = 1; i <= max; i++) {
			paths.add(Paths.get("test" + i + ".txt"));
		}

		return paths;
	}

	@Test
	public void testAddOnly() throws InterruptedException {
		int num = 10;
		int threads = 5;
		int timeout = 30000;

		ThreadSafePathSet paths = new ThreadSafePathSet();
		List<Thread> workers = new ArrayList<>();

		for (int i = 0; i < threads; i++) {
			workers.add(new AddPathWorker(paths, num));
		}

		assertConcurrent("testAddOnly()", workers, timeout);
		Assert.assertEquals(expected(num), paths.sortedCopy());
	}

	@Test
	public void testAddAllOnly() throws InterruptedException {
		int num = 10;
		int threads = 5;
		int timeout = 30000;

		ThreadSafePathSet paths = new ThreadSafePathSet();
		List<Thread> workers = new ArrayList<>();

		for (int i = 0; i < threads; i++) {
			workers.add(new AddAllWorker(paths, num));
		}

		assertConcurrent("testAddAllOnly()", workers, timeout);
		Assert.assertEquals(expected(num), paths.sortedCopy());
	}

	@Test
	public void testSmallDoubleAddCopy() throws InterruptedException {
		int num = 10;
		int timeout = 30000;

		ThreadSafePathSet paths = new ThreadSafePathSet();
		List<Thread> workers = new ArrayList<>();

		workers.add(new AddPathWorker(paths, num));
		workers.add(new CopyPathWorker(paths, num));

		assertConcurrent("testSmallDoubleAddCopy()", workers, timeout);
		Assert.assertEquals(expected(num), paths.sortedCopy());
	}

	@Test
	public void testLargeDoubleAddCopy() throws InterruptedException {
		int num = 1000;
		int timeout = 30000;

		ThreadSafePathSet paths = new ThreadSafePathSet();
		List<Thread> workers = new ArrayList<>();

		workers.add(new AddPathWorker(paths, num));
		workers.add(new CopyPathWorker(paths, num));

		assertConcurrent("testLargeDoubleAddCopy()", workers, timeout);
		Assert.assertEquals(expected(num), paths.sortedCopy());
	}

	@Test
	public void testSmallMultiAddCopy() throws InterruptedException {
		int num = 10;
		int threads = 5;
		int timeout = 30000;

		ThreadSafePathSet paths = new ThreadSafePathSet();
		List<Thread> workers = new ArrayList<>();

		for (int i = 0; i < threads; i++) {
			workers.add(new AddPathWorker(paths, num));
			workers.add(new CopyPathWorker(paths, num));
		}

		assertConcurrent("testSmallMultiAddCopy()", workers, timeout);
		Assert.assertEquals(expected(num), paths.sortedCopy());
	}

	@Test
	public void testLargeMultiAddCopy() throws InterruptedException {
		int num = 1000;
		int threads = 5;
		int timeout = 30000;

		ThreadSafePathSet paths = new ThreadSafePathSet();
		List<Thread> workers = new ArrayList<>();

		for (int i = 0; i < threads; i++) {
			workers.add(new AddPathWorker(paths, num));
			workers.add(new CopyPathWorker(paths, num));
		}

		assertConcurrent("testSmallMultiAddCopy()", workers, timeout);
		Assert.assertEquals(expected(num), paths.sortedCopy());
	}

	/** Forces several write operations */
	private static class AddPathWorker extends Thread {

		private ThreadSafePathSet paths;
		private int num;

		public AddPathWorker(ThreadSafePathSet paths, int num) {
			this.paths = paths;
			this.num = num;
		}

		@Override
		public void run() {
			for (int i = 1; i <= num; i++) {
				paths.add(Paths.get("test" + i + ".txt"));
			}
		}
	}

	/** Forces a single write operation */
	private static class AddAllWorker extends Thread {

		private ThreadSafePathSet paths;
		private int num;

		public AddAllWorker(ThreadSafePathSet paths, int num) {
			this.paths = paths;
			this.num = num;
		}

		@Override
		public void run() {
			ArrayList<Path> local = new ArrayList<>();

			for (int i = 1; i <= num; i++) {
				local.add(Paths.get("test" + i + ".txt"));
			}

			paths.addAll(local);
		}
	}

	/** Forces several read operations **/
	private static class CopyPathWorker extends Thread {

		private ThreadSafePathSet paths;
		private int num;

		public CopyPathWorker(ThreadSafePathSet paths, int num) {
			this.paths = paths;
			this.num = num;
		}

		@Override
		public void run() {
			for (int i = 0; i < num; i++) {
					paths.sortedCopy();
			}
		}
	}

	/**
	 * Handles multithreading in such a way that concurrent modification
	 * exceptions may be detected, causing the test to fail. Code comes from:
	 * https://github.com/junit-team/junit/wiki/Multithreaded-code-and-concurrency
	 *
	 * @param message - test message
	 * @param runnables - runnable objects to execute
	 * @param maxTimeoutSeconds - timeout for test
	 * @throws InterruptedException
	 */
	public static void assertConcurrent(final String message,
			final List<? extends Runnable> runnables,
			final int maxTimeoutSeconds) throws InterruptedException {

		final int numThreads = runnables.size();
		final List<Throwable> exceptions = Collections.synchronizedList(new ArrayList<Throwable>());
		final ExecutorService threadPool = Executors.newFixedThreadPool(numThreads);

		try {
			final CountDownLatch allExecutorThreadsReady = new CountDownLatch(numThreads);
			final CountDownLatch afterInitBlocker = new CountDownLatch(1);
			final CountDownLatch allDone = new CountDownLatch(numThreads);

			for (final Runnable submittedTestRunnable : runnables) {
				threadPool.submit(new Runnable() {
					@Override
					public void run() {
						allExecutorThreadsReady.countDown();
						try {
							afterInitBlocker.await();
							submittedTestRunnable.run();
						} catch (final Throwable e) {
							exceptions.add(e);
						} finally {
							allDone.countDown();
						}
					}
				});
			}

			// wait until all threads are ready
			Assert.assertTrue(
					"Timeout initializing threads! Perform long lasting "
					+ "initializations before passing runnables to assertConcurrent",
					allExecutorThreadsReady.await(runnables.size() * 10,
							TimeUnit.MILLISECONDS));

			// start all test runners
			afterInitBlocker.countDown();
			Assert.assertTrue(message + " timeout! More than"
					+ maxTimeoutSeconds + "seconds",
					allDone.await(maxTimeoutSeconds, TimeUnit.SECONDS));
		} finally {
			threadPool.shutdownNow();
		}

		Assert.assertTrue(message + " failed with exception(s)" + exceptions,
				exceptions.isEmpty());
	}

}

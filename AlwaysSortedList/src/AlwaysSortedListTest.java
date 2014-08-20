
import org.apache.logging.log4j.Level;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests {@link AlwaysSortedList} is properly synchronized. If you have questions
 * on what it means to fail a specific test, please post on Piazza!
 */
public class AlwaysSortedListTest {

	private static final int iterations = 10;
	private static final int threads = 5;

	@Test(timeout = 3000)
	public void testAddSingle() throws InterruptedException {
		AlwaysSortedList list = new AlwaysSortedList();

		Thread worker = new AddWorker(list, "AS");
		worker.start();
		worker.join();

		Assert.assertEquals(
				"[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]",
				list.toString());
	}

	@Test(timeout = 3000)
	public void testAddMultiple() throws InterruptedException {
		AlwaysSortedList list = new AlwaysSortedList();
		Thread[] workers = new Thread[threads];

		for (int i = 0; i < workers.length; i++) {
			workers[i] = new AddWorker(list, "AM" + i);
			workers[i].start();
		}

		for (Thread worker : workers) {
			worker.join();
		}

		Assert.assertEquals(
				list.toString(),
				iterations * threads,
				list.size());
	}

	@Test(timeout = 3000)
	public void testAddPopSingle() throws InterruptedException {
		AlwaysSortedList list = new AlwaysSortedList();

		Thread popWorker = new PopWorker(list, "APS");
		popWorker.start();

		Thread addWorker = new AddWorker(list, "APS");
		addWorker.start();

		addWorker.join();
		popWorker.join();

		Assert.assertEquals(
				list.toString(),
				0,
				list.size());
	}

	@Test(timeout = 3000)
	public void testAddPopMulti() throws InterruptedException {
		AlwaysSortedList list = new AlwaysSortedList();

		Thread popWorker = new PopWorker(list, "APM1");
		popWorker.start();

		Thread[] workers = new Thread[threads];

		for (int i = 0; i < workers.length; i++) {
			workers[i] = new AddWorker(list, "APM" + i);
			workers[i].start();
		}

		for (Thread worker : workers) {
			worker.join();
		}

		popWorker.join();

		Assert.assertEquals(
				list.toString(),
				iterations * threads - iterations,
				list.size());
	}

	private static class AddWorker extends Thread {
		private AlwaysSortedList list;

		public AddWorker(AlwaysSortedList list, String id) {
			super("AddWorker" + id);
			this.list = list;
		}

		@Override
		public void run() {
			for (int i = iterations - 1; i >= 0; i--) {
				list.add(String.valueOf(i));
				Thread.yield();
			}

			AlwaysSortedList.logger.log(Level.DEBUG, "{} finished.",
					Thread.currentThread().getName());
		}
	}

	private static class PopWorker extends Thread {
		private AlwaysSortedList list;

		public PopWorker(AlwaysSortedList list, String id) {
			super("PopWorker" + id);
			this.list = list;
		}

		@Override
		public void run() {
			for (int i = 0; i < iterations; i++) {
				list.pop();
			}

			AlwaysSortedList.logger.log(Level.DEBUG, "{} finished.",
					Thread.currentThread().getName());
		}
	}
}

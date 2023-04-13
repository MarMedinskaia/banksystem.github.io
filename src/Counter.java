import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter implements Runnable {
	private int count;
	private Lock counterLock;

	public Counter() {
		count = 0;
		counterLock = new ReentrantLock();
	}

	public void increment() {
		//counterLock.lock();
		count++;
		System.out.println(Thread.currentThread().getName() + " increments count to " + this.count);
		//counterLock.unlock();
	}

	public void decrement() {
		//counterLock.lock();
		count--;
		System.out.println(Thread.currentThread().getName() + " decrements count to " + this.count);
		//counterLock.unlock();
	}

	public void run() {
		counterLock.lock();
		this.increment();

		try {
			Thread.sleep(10);// finish some other process
		} catch (InterruptedException e) {
			e.printStackTrace();
		}			
		this.decrement();
		counterLock.unlock();
	}
}

/*
 * import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter implements Runnable {
	private int count;
	private Lock counterLock;

	public Counter() {
		count = 0;
		counterLock = new ReentrantLock();
	}

	public void increment() {

		counterLock.lock();
		count++;
		System.out.println(Thread.currentThread().getName() + " increments count to " + this.getCount());
		counterLock.unlock();
	}

	public void decrement() {
		counterLock.lock();
		count--;
		System.out.println(Thread.currentThread().getName() + " decrements count to " + this.getCount());
		counterLock.unlock();
	}

	public int getCount() {
		return count;
	}

	public void run() {
		this.increment();

		try {
			// finish some other process
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}			
		// decrementing
		this.decrement();
	}
}
*/

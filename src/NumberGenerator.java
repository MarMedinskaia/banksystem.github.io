import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NumberGenerator implements Runnable{
	private ArrayList<Integer> toProcess = new ArrayList<Integer>();
	private Random gen = new Random();
	
	private Lock listLock = new ReentrantLock();
	private Condition emptyList = listLock.newCondition();
	
	@Override
	public void run(){
		try {
			while(true) {
				for (int i = 0; i<3; i++) {
					listLock.lock();
					toProcess.add(gen.nextInt(1000000000));
					emptyList.signalAll();
					listLock.unlock();
				}
			
				Thread.sleep(10000);
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting due to interruption");
		}
		
	}
	
	public int getNext() throws InterruptedException{
		listLock.lock();
		while (toProcess.isEmpty()) {
			emptyList.await();
		}
		int val = toProcess.remove(0);
		listLock.unlock();
		return val;
	}
}

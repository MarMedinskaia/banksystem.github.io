
public class RaceConditionDemo {

	public static void main(String[] args) {
		Counter counter = new Counter();
		Thread t1 = new Thread(counter);
		Thread t2 = new Thread(counter);
		Thread t3 = new Thread(counter);
		t1.start();
		t2.start();
		t3.start();
	}
	
}


public class AlphabetThreadDemo {
	public static void main(String[] args)  {
		AlphabetRunnable task1 = new AlphabetRunnable();
		AlphabetRunnable task2 = new AlphabetRunnable();
		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		thread1.start();	
		thread2.start();	
	}
}

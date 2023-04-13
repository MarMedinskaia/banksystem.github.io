
public class AlphabetThreadJoinExample {
	//We know that this thread won't be interrupted,
	//so throws InterruptedException is ok
	public static void main(String[] args) throws InterruptedException {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + ": Starting thread to print out alphabet, but I'm in a hurry.");
		
		AlphabetRunnable task = new AlphabetRunnable();
		Thread thread1 = new Thread(task);
		thread1.start();
		

	    Thread.sleep(3000);
	    if(thread1.isAlive()) {
	        System.out.println(threadName + ": This is boring...interrupting the thread now");
	
	        thread1.interrupt();
	        // -- wait indefinitely - til the thread shuts down
	        thread1.join();
	        
	        System.out.println(threadName + ": Finally!");
	    }
	}
}

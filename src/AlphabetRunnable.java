
public class AlphabetRunnable implements Runnable {
	public void run() {
		String threadName = Thread.currentThread().getName();
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		try {
			for(char c: alphabet) {
				Thread.sleep(1000);
				System.out.println(threadName + " says " + c);
			}
		}catch(InterruptedException e) {
			System.out.println(threadName + " is interrupted");
		}
		System.out.println(threadName + " run method is now complete.");
		
	}
}

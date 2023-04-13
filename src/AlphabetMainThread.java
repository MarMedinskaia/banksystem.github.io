
public class AlphabetMainThread {
	public static void main(String[] args) {
		String threadName = Thread.currentThread().getName();
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		try {
			for(char c: alphabet) {
				Thread.sleep(1000);
				System.out.println("Thread " + threadName + " says " + c);
			}
		}catch(InterruptedException e) {
			System.out.println("You interrupted thread " + threadName);
		}
	}

}

import java.util.Date;

public class ArguingRunnable implements Runnable{
	private String argument;
	private static final int REPEATS = 10, DELAY = 2000;
	
	public ArguingRunnable(String argument) {
		this.argument = argument;
	}
	
	public void run() {
		try {
			for(int i = 0; i < REPEATS; i++) {
				Date now = new Date();
				System.out.println(now + "\t" + argument);
				Thread.sleep(DELAY);
			}
			
		}catch(InterruptedException e) {
			System.out.println("We'll finish this later.");
		}
	}
	
}

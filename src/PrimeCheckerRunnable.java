public class PrimeCheckerRunnable implements Runnable {
	private NumberGenerator ng;
	private String name;
	
	public PrimeCheckerRunnable(NumberGenerator ng) {
		this.ng = ng;
	}
	
	@Override
	public void run() {
		this.name = Thread.currentThread().getName();
		try {
			while(true) {
				int val = ng.getNext();			
				System.out.println(name+": "+val + " is " + (isPrime(val)?"":"not ") + "prime.");				
			}
		} catch (InterruptedException e) {
			System.out.println(name + "exiting due to interruption");
		}
	}
	
	public static boolean isPrime(int n) {
		for (int i=2; i <= Math.sqrt(n); i++) {
			if (n%i == 0 ) {
				return false;
			}
		}
		return true;
	}
}

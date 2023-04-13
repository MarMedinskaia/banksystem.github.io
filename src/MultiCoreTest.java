import java.sql.Date;
import java.time.ZonedDateTime;
import javax.swing.Timer;
/**
 * A test program to demonstrate when threads are truly running in parallel.
 * Change the number of threads started in main.  If parallel processing takes place 2 threads
 * will be about twice as fast as 1, etc.  
 * @author Chris Schmidt
 *
 */
public class MultiCoreTest {
	static final int threadCount=3;
	
	private static int count=0; //a counter for the timer

	public static void main(String[] args) {
		 Timer t = new Timer(1000,e-> {System.out.println("time passed: " + ++count + "s");});
		 t.start();
		 
			System.out.println(Thread.activeCount());
		 for (int i = 0; i<threadCount; i++) {
				System.out.println(Thread.activeCount());
			 (new Thread(new doStuff())).start();
		 }
	}
	
	/**
	 * Checks whether a number is prime
	 * @param the number in question
	 * @return true if n is prime
	 */
	public static boolean isPrime(int n) {
		for (int i=2; i < Math.sqrt(n); i++) {
			if (n%i == 0 ) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Sums all factors of a number including 1 and the number itself.
	 * @param n
	 * @return
	 */
	public static int factorsSum(int n) {
		 int sum=1+n;
		 for (int i=2; i <= n/2; i++) {
			 if (n%i == 0 ) {
				 	sum+=i;
			 }
		 }
		 return sum;
	} 
	
	
	
	//volatile forces each thread to get the current value of next from memory
	//otherwise threads may use an old cached value and end up checking the same number
	private volatile static int next = 1; //the next number to check if its factors sum to a prime number
	
	//A Runnable class that does some math busy work.  
	//It prints out numbers whose factors sum to a prime number
	//Each thread gets the next number to check from the next data member
	private static class doStuff implements Runnable {
		 
		 public void run() {
			  while (true) {
				   int n = next++;
				   
				   if (isPrime(factorsSum(n))) {
					   System.out.println(Thread.currentThread().getName()+ ": " + n);
				   }
			  }
		 }
	}
	
}
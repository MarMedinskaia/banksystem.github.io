import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	private int number;
	private double balance;
	private Lock balanceLock;
	
	private Condition lowfunds;

	public Account(int number, double balance) {
		this.number = number;
		this.balance = balance;
		
		balanceLock = new ReentrantLock();
		lowfunds = balanceLock.newCondition();
	}

	public void deposit(double amount) {
		balanceLock.lock();
		try {
			double newBalance = balance + amount;
			System.out.println("Depositing: " + amount + " new balance: " + newBalance);
			balance = newBalance;
			
			lowfunds.signalAll();
		} finally {
			balanceLock.unlock();
		}
	}

	public void withdraw(double amount) {
		balanceLock.lock();
		try {
			while (balance<amount) {
				lowfunds.await();
			}
			double newBalance = balance - amount;
			System.out.println("Withdrawing: " + amount + " new balance " + newBalance);
			balance = newBalance;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			balanceLock.unlock();
		}
	}

	public int getNumber() {
		return number;
	}

	public double getBalance() {
		return balance;
	}

	public String toString() {
		return "Account number: " + this.number + " has balance: $" + this.balance;
	}
}

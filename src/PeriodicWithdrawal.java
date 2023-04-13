
public class PeriodicWithdrawal implements Runnable {
	private Account account;
	private int repeats;
	private double amount;

	private static final int DELAY = 1000;

	public PeriodicWithdrawal(Account account, double amount, int repeats) {
		this.account = account;
		this.amount = amount;
		this.repeats = repeats;
	}

	public void run() {
		try {
			for (int i = 1; i <= repeats; i++) {
				account.withdraw(amount);
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

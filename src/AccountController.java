
public class AccountController {

	public static void main(String[] args) {
		Account savings = new Account(100000, 0);
		PeriodicDeposit pd = new PeriodicDeposit(savings, 100, 3);
		PeriodicWithdrawal pw = new PeriodicWithdrawal(savings, 100, 3);
		
		Thread depositThread = new Thread(pd);
		Thread withdrawThread = new Thread(pw);
		depositThread.start();
		withdrawThread.start();
		

	}

}

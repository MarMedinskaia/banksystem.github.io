public class PrimeCheckerExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberGenerator ng = new NumberGenerator();
		Thread t = new Thread(ng);
		t.start();
		
		for (int i=0; i<4; i++) {
			(new Thread(new PrimeCheckerRunnable(ng))).start();
		}

	}

}

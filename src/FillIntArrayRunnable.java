import java.util.Random;

public class FillIntArrayRunnable implements Runnable {

	private int[] toBeFilled;
	private int startIndex;
	private int endIndex;
	
	
	public FillIntArrayRunnable(int[] toBeFilled, int start, int end) {
		this.toBeFilled = toBeFilled;
		this.startIndex = start;
		this.endIndex = end;
	}
	
	@Override
	public void run() {
		Random gen = new Random();
		
		for(int i=startIndex; i<=endIndex; i++) {
			toBeFilled[i] = gen.nextInt(201)-100;
		}

	}

}


public class SumIntArrayRunnable implements Runnable {
	private int[] toBeFilled;
	private int startIndex;
	private int endIndex;
	
	private int sum;
	
	public SumIntArrayRunnable(int[] toFill, int start, int end) {
		this.toBeFilled = toFill;
		this.startIndex = start;
		this.endIndex = end;
	}
	
	@Override
	public void run() {
		int tempSum=0;
		for(int i=startIndex; i<=endIndex; i++) {
			tempSum+=toBeFilled[i];
		}
		sum = tempSum;
	}

	public int getSum() {
		return sum;
	}

}

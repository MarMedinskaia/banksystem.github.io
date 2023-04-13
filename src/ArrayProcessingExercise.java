
public class ArrayProcessingExercise {

	public static void main(String[] args) throws InterruptedException {
		int size = 500000000;
		int[] values = new int[size];

		System.out.println("Before filling array");
		Thread[] threads = new Thread[4];
		int pieceLength = size / 4;
		for(int i=0;i<4;i++) {
			int start = i*pieceLength;
			int end = start + pieceLength - 1;
			threads[i] = new Thread(new FillIntArrayRunnable(values,start,end));
			//System.out.println("s:"+start+" e:"+end);
			threads[i].start();
		}

		for(int i=0;i<4;i++) {
			threads[i].join();
		}
		
		System.out.println(values[0] + "  " + values[size/2] + "  " + values[size-1]);
		System.out.println("After filling array");
		
		
		SumIntArrayRunnable[] sumRunnables = new SumIntArrayRunnable[4];
		for(int i=0;i<4;i++) {
			int start = i*pieceLength;
			int end = start + pieceLength - 1;
			sumRunnables[i] = new SumIntArrayRunnable(values,start,end);
			threads[i] = new Thread(sumRunnables[i]);
			//System.out.println("s:"+start+" e:"+end);
			threads[i].start();
		}		
		int sum = 0;
		for(int i=0;i<4;i++) {
			threads[i].join();
			sum+=sumRunnables[i].getSum();
		}
		System.out.println("Sum: " + sum);
		
	}

}

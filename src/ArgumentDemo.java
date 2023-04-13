
public class ArgumentDemo {

	public static void main(String[] args) {
		ArguingRunnable a1 = new ArguingRunnable("Guh-if, you don't call it a Jarden, do you?");
		ArguingRunnable a2 = new ArguingRunnable("Jiff, like giraffe it's not a Guh-raffe.");
		Thread gif = new Thread(a1);
		Thread jif = new Thread(a2);
		jif.start();
		gif.start();
	}
}

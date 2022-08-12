package thread;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		StringThread stringThreadObject = new StringThread();
		NumberThread numberThreadObject = new NumberThread();
		
		stringThreadObject.start();
		Thread.sleep(10000);
		numberThreadObject.start();
	}
}
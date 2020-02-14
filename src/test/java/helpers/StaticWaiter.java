package helpers;

public class StaticWaiter {

	public static void wait(int milis) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

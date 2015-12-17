package tw.leonchen.oop.thread;

class TestThreadEx1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			//System.out.print(Thread.currentThread().getName() + " ");
			//System.out.println("i=" + i);
			System.out.println(Thread.currentThread().getName() + " i=" + i);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
}

public class CallTestThreadEx1 {

	public static void main(String[] args) {
		TestThreadEx1 test1 = new TestThreadEx1();
		Thread thread1 = new Thread(test1);
		Thread thread2 = new Thread(test1);
		Thread thread3 = new Thread(test1);
		thread1.start();
		thread2.start();
		thread3.start();
		try {
//			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("finished");
	}
}

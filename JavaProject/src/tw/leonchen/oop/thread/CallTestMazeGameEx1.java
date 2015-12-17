package tw.leonchen.oop.thread;

class TestGameCore {
	private int x = 0, y = 0;

	public void setPosition(int x, int y) {
		synchronized (this) {
			this.x = x;
			this.y = y;
			System.out.println("x=" + x + " y=" + y);
			this.notify();
		}
	}

	public void checkPostion() {
		synchronized (this) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (x == 0 && y == 0) {
				System.out.println("Game Exited");
				System.exit(-1);
			}
		}
	}
}

class TestGameCore_Execute implements Runnable {

	private TestGameCore core;

	public TestGameCore_Execute(TestGameCore core) {
		this.core = core;
	}

	@Override
	public void run() {
		while(true){
			int x = (int)(Math.random()*5);
			int y = (int)(Math.random()*5);
			core.setPosition(x, y);
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class TestGameCore_Check implements Runnable {

	private TestGameCore core;

	public TestGameCore_Check(TestGameCore core) {
		this.core = core;
	}

	@Override
	public void run() {
		while(true){
			core.checkPostion();
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class CallTestMazeGameEx1 {

	public static void main(String[] args) {
		
		System.out.println("Game acivated .......");
		TestGameCore core = new TestGameCore();
		
		TestGameCore_Execute execute = new TestGameCore_Execute(core);
		Thread thread1 = new Thread(execute);
		thread1.start();

		TestGameCore_Check check = new TestGameCore_Check(core);
		Thread thread2 = new Thread(check);
		thread2.start();
	}

}

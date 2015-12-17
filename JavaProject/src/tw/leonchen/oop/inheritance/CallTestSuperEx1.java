package tw.leonchen.oop.inheritance;

class TestSuperEx1 /* extends Object */{
	// class TestSuperEx1 is subclass of java.lang.Object by system default
	public TestSuperEx1() {
		//this(6);
		System.out.println("run here");
	}

	public TestSuperEx1(int value) {
		super();
		// public TestSuperEx1 is Constructor

		System.out.println("value=" + value);
	}

	public void exec() {
		System.out.println("execute");
	}
}

public class CallTestSuperEx1 extends TestSuperEx1 {

	public CallTestSuperEx1() {
		 //super();
	}

	public void run() {
		super.exec();
	}

	public static void main(String[] args) {
		CallTestSuperEx1 test1 = new CallTestSuperEx1();
		test1.exec();
		test1.run();
	}

}

package test;

public class TestConstructor {

	TestConstructor() {
		System.out.println("void constructor");
	}

	TestConstructor(int a) {
		System.out.println(a);
	}

	public void testMethod() {
		System.out.println("void method");
	}

	public void testMethod(int b) {
		System.out.println(b);
	}

	public static void main(String[] args) {
		TestConstructor constructor = new TestConstructor(9);
		constructor.testMethod(5);		
	}

}

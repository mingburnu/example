package tw.leonchen.oop;

public class TestVariableScopeEx1 {

	int a = 1; // instance variable
	static int b = 2; // static variable

	public void f1(int c) { // local variable
		int d = 4; // local variable

		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("c=" + c);
		System.out.println("d=" + d);
	}

	public static void f2(int e) {
		// System.out.println("a=" + a); //compile error
		System.out.println("b=" + b);
		// System.out.println("c=" + c); //compile error
		// System.out.println("d=" + d); //compile error
		System.out.println("e=" + e);
	}

	public static void main(String[] args) {
		TestVariableScopeEx1 scope1 = new TestVariableScopeEx1();
		scope1.f1(3);
		System.out.println(TestVariableScopeEx1.b);
		scope1.a = 8;
		scope1.b = 15;
		System.out.println(TestVariableScopeEx1.b);
		scope1.f2(5);
		TestVariableScopeEx1.f2(6);
		f2(7);

		TestVariableScopeEx1 scope2 = new TestVariableScopeEx1();
		System.out.println("scope2.a=" + scope2.a);
		System.out.println("scope2.b=" + scope2.b);

	}

}

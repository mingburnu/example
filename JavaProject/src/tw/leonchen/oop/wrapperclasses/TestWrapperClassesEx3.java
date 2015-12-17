package tw.leonchen.oop.wrapperclasses;

public class TestWrapperClassesEx3 {
	public static void main(String[] args) {
		// int A=10 == Integer A = new Integer(10)
		Integer A = new Integer(10); // Boxing
		int B = A.intValue(); // Unboxing
		System.out.println(B);
		B = A; // auto-unboxing
		A = 20; // auto-boxing
		System.out.println(A);
	}
}

package tw.leonchen.oop.io;

public class PrintfDemo {

	public static void main(String[] args) {
		String a = "Three are %d dogs and %d cats.\n";
		String b = "Three are %f dogs and %f cats.\n";
		String c = "Three are %s dogs and %s cats.\n";

		System.out.printf(a, 33, 22);
		System.out.printf(b, 11.0, 3.0);
		System.out.printf(c, "54", "87");
	}
}

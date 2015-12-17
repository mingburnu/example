package lab;

public class TestEvenOddLab2 {
	public static void main(String args[]) {
		int number = -1;

		if (number > 0 && (number % 2 == 0)) {
			System.out.println(number + " is positive even");
		} else if (number > 0 && (number % 2 != 0)) {
			System.out.println(number + " is positive odd");
		} else if (number < 0 && (number % 2 == 0)) {
			System.out.println(number + " is negative even");
		} else if (number < 0 && (number % 2 != 0)) {
			System.out.println(number + " is negative odd");
		} else {
			System.out.println(number + " isn't positive nor negative");
		}
	}
}

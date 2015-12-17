package lab;

public class BuildStyleEx2 {

	public static void main(String[] args) {
		for (int j = 1; j <= 5; j++) {

			for (int i = 5; i >= j; i--) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}
}
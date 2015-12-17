package lab;

public class BuildStyleEx3 {

	public static void main(String[] args) {
		for (int j = 1; j <= 5; j++) {

			for (int i = 5; i > j; i--) {
				System.out.print(" ");
			}
			for (int k = 0; k < j; k++) {
				System.out.print("+ ");
			}
			System.out.println("");
		}
		for (int j = 1; j <= 5; j++) {

			for (int i = 0; i < j; i++) {
				System.out.print(" ");
			}
			for (int k = 5; k > j; k--) {
				System.out.print("+ ");
			}
			System.out.println("");
		}		
		
		
	}
}
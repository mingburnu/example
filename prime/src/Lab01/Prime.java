package Lab01;

public class Prime {
	public static void main(String[] args) {
		int num = 3;
		int limit = (int) Math.sqrt(num);

	for (int i = 2; i <= limit; i++) {
			if (num % i == 0) {
				System.out.print(num + " isn't prime");
				break;
			}
			
		}
	System.out.print(num + " is prime");

	}

}

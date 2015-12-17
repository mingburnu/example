package test;

public class loop99 {

	public loop99() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		for (int k = 1; k == 1; k++) {
			for (int j = 1; j < 10; j++) {
				for (int i = 1; i < 10; i++) {

					if (j <= i && i * j < 10) {
						System.out.print(j + "X" + i + "= " + i * j + " ");
					} else if (j <= i && i * j >= 10) {
						System.out.print(j + "X" + i + "=" + i * j + " ");
					}
				}

				System.out.print("\n");
			}
		}

	}

}

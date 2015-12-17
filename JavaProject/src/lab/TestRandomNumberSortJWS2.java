package lab;

public class TestRandomNumberSortJWS2 {

	public static void main(String[] args) {
		int[] numberCount = new int[42];
		int[] number = new int[42];
		for (int i = 1; i <= 1000; i++) {
			int rNum = (int) (Math.random() * 42) + 1;
			numberCount[rNum - 1] = numberCount[rNum - 1] + 1;
			System.out.println("numberCount[rNum - 1]=" + numberCount[rNum - 1]
					+ " " + "rNum=" + rNum);
		}
		for (int j = 0; j < number.length; j++) {
			number[j] = j + 1;
			System.out.println("number[j]=" + number[j]);
		}

		for (int k = 0; k < numberCount.length; k++) {
			System.out
					.print("number" + number[k] + ":" + numberCount[k] + "  ");
			if ((k + 1) % 5 == 0) {
				System.out.println();
			}
		}
		System.out.println("============================================");
		for (int i = 0; i < numberCount.length - 1; i++) {
			for (int j = i + 1; j < numberCount.length; j++) {
				int temp1 = 0, temp2 = 0;
				if (numberCount[i] < numberCount[j]) {
					temp1 = numberCount[i];
					numberCount[i] = numberCount[j];
					numberCount[j] = temp1;

					temp2 = number[i];
					number[i] = number[j];
					number[j] = temp2;
				}
			}
		}
		for (int k = 0; k < numberCount.length; k++) {
			System.out
					.print("number" + number[k] + ":" + numberCount[k] + "  ");
			if ((k + 1) % 5 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}
}

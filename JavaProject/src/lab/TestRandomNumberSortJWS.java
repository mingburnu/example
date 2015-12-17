package lab;

public class TestRandomNumberSortJWS {

	int[] numberCount = new int[42];
	int[] number = new int[42];

	public void createRandomNumber() {
		for (int i = 1; i <= 100000; i++) {
			int rNum = (int) (Math.random() * 42) + 1;
			 System.out.println("rNum=" + rNum);
			numberCount[rNum - 1] = numberCount[rNum - 1] + 1;
		}

		for (int j = 0; j < number.length; j++) {
			number[j] = j + 1;
		}
	}

	public void randomNumberSort() {
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
	}

	public void printNumber() {
		for (int k = 0; k < numberCount.length; k++) {
			System.out.print(number[k] + ":" + numberCount[k] + "	");
			if ((k + 1) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		TestRandomNumberSortJWS numberSort = new TestRandomNumberSortJWS();
		numberSort.createRandomNumber();
		System.out.println("Original Data:");
		System.out.println("------------------------------------------------------------");
		numberSort.printNumber();
		System.out.println("------------------------------------------------------------");
		numberSort.randomNumberSort();
		System.out.println("Sorted Data:");
		System.out.println("------------------------------------------------------------");
		numberSort.printNumber();
		System.out.println("------------------------------------------------------------");
	}

}

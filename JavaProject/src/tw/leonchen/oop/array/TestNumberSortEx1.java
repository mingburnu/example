package tw.leonchen.oop.array;

public class TestNumberSortEx1 {

	int[] data = { 5, 12, 7, 15, 32, 6 };

	public void numberSort1() {
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				int temp = 0;
				if (data[i] < data[j]) {
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
	}

	public void numberSort2() {//bubble sort
		while (true) {
			int count=0;
			for (int i = 0; i < data.length -1; i++) {
				int temp = 0;
				if (data[i] < data[i + 1]) {
					temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;
					count++;
				}
			}
			
			if(count==0){
				break;
			}
		}
	}

	public void print() {
		for (int k = 0; k < data.length; k++) {
			System.out.println("data[" + k + "]=" + data[k]);
		}
	}

	public static void main(String[] args) {
		TestNumberSortEx1 numberSort = new TestNumberSortEx1();
		numberSort.print();
		System.out.println("------------------------------------");
		numberSort.numberSort1();
		numberSort.print();
		System.out.println("------------------------------------");
	}

}

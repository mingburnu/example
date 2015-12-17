package tw.leonchen.oop.array;

public class Test2DimArrayWithEnhancedForLoopEx3 {

	public static void main(String[] args) {
		int[][] data = new int[3][3];
		data[0][0] = 0;
		data[1][1] = 1;
		data[2][2] = 2;		

		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				System.out.println("data[" + i + "][" + j + "]=" + data[i][j]);
			}
		}
	}
}

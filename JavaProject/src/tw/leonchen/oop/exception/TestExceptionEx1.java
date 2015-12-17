package tw.leonchen.oop.exception;

public class TestExceptionEx1 {

	public static void main(String[] args) {
		try {
			int[] data = { 1, 2, 3, 4, 5 };

			for (int i = 0; i >= 0; i++) {
				System.out.println("data[" + i + "]=" + data[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("finished");
			System.out.println("e1=" + e);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("e2=" + e);
		}
	}
}

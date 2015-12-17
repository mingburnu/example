package tw.leonchen.oop.array;

public class TestArgsArrayEx1 {

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "]=" + args[i]);
		}

		System.out.println("finished");
	}
}

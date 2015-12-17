package tw.leonchen.oop;

class TestStaticEx1 {
	public static int level_value = 11;

	public static void playGame() {
		System.out.println("Game play:" + level_value);
	}
}

public class CallTestStaticEx1 {

	public static void main(String[] args) {
		System.out.println(TestStaticEx1.level_value);
		System.out.println(TestStaticEx1.level_value);
		TestStaticEx1.level_value = 15;
		System.out.println(TestStaticEx1.level_value);
		TestStaticEx1.level_value = 20;
		TestStaticEx1.playGame();
		System.out.println(TestStaticEx1.level_value);
		System.out.println("finished");
		System.out.println(TestStaticEx1.level_value);
	}
}

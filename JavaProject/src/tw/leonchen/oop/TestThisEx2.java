package tw.leonchen.oop;

public class TestThisEx2 {

	int x=2, y=3;
	
	public void function(int x, int y){
		//x=x;
		this.y=y;
	}
	
	public static void main(String[] args) {
		TestThisEx2 test1 = new TestThisEx2();
		test1.function(7, 5);
		System.out.println("test1.x=" + test1.x);
		System.out.println("test1.y=" + test1.y);
		System.out.println("finished");
	}
}

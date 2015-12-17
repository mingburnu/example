package tw.leonchen.oop.overload;

public class TestOverloadEx1 {

	public TestOverloadEx1(){
		System.out.println("run here");
	}
	
	public TestOverloadEx1(int num){
		System.out.println("num=" + num);
	}
	
	public void sum(int x, int y){
		System.out.println("(x+y)_1=" + (x+y));
	}
	
	public void sum(double x, double y){
		System.out.println("(x+y)_2=" + (x+y));
	}
	
	public static void main(String[] args) {
		TestOverloadEx1 overload = new TestOverloadEx1();
		overload.sum(10.00,7);
		System.out.println("finished");
		
	}

}

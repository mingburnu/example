package tw.leonchen.oop;

public class TestThisEx1 {

	public TestThisEx1(){
		System.out.println("TestThisEx1()");
	}
	
	public TestThisEx1(int a){
		this();
		System.out.println("TestThisEx1(int)");
	}
	
	public static void main(String[] args) {
		TestThisEx1 test1 = new TestThisEx1(12);
	}

}

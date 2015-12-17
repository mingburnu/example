package tw.leonchen.oop;

public class TestConstructorEx1 {

	public TestConstructorEx1(int value){
		System.out.println("TestConstructorEx1():" + value);
	}
	
	public void execute(){
		System.out.println("execute process");
	}
	
	public static void main(String[] args) {
		TestConstructorEx1 test1 = new TestConstructorEx1(12);
		test1.execute();
		System.out.println("finished");
	}
}

package tw.leonchen.oop;

public class TestConstructorEx2 {

	public TestConstructorEx2(int value){
		System.out.println("TestConstructorEx1():" + value);
	}
	
	public void execute(){
		System.out.println("execute process");
	}
	
	public static void main(String[] args) {
		TestConstructorEx2 test2 = new TestConstructorEx2(12);
		test2.execute();
		test2.execute();
		
		new TestConstructorEx2(24).execute();
		new TestConstructorEx2(16).execute();
		
		System.out.println("finished");
		
		int num=5;
		System.out.println("num+1=" + (num+1));
		
		System.out.println("5+1=" + (5+1));
	}

}

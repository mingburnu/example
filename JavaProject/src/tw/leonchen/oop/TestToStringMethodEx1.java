package tw.leonchen.oop;

public class TestToStringMethodEx1 {

	public String toString(){
		return "test";
	}
	
	public static void main(String[] args) {
		TestToStringMethodEx1 test1 = new TestToStringMethodEx1();
		System.out.println(test1);
		System.out.println(test1.toString());
	}

}

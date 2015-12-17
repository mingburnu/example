package tw.leonchen.oop.wrapperclasses;

public class TestWrapperClassesEx1 {

	public static void main(String[] args) {
		int num1=6;
		Integer i1 = new Integer(num1);  //Boxing
		int num2 = i1.intValue();  //UnBoxing
		System.out.println("num2+1=" + (num2+1));

		
		Integer i2 = 7;
		int num4 = i2+100;
		System.out.println("num4=" + num4);
	}

}

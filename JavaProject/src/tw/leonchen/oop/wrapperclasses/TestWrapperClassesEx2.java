package tw.leonchen.oop.wrapperclasses;

public class TestWrapperClassesEx2 {

	public static void main(String[] args) {
		String value="7";
		System.out.println("value+1=" + (value+1));
		
		Integer i1 = new Integer(value);
		int num1 = i1.intValue();
		System.out.println("num1+1=" + (num1+1));
		
		int num2 = Integer.parseInt(value);
		System.out.println("num2+2=" + (num2+2));
		
		Integer i2 = Integer.valueOf(value);
		int num3 = i2.intValue();
		System.out.println("num3+3=" + (num3+3));
		
		int num4 = Integer.valueOf(value).intValue();
		System.out.println("num4+4=" + (num4+4));

	}

}

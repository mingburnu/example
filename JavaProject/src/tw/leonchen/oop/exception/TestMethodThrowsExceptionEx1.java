package tw.leonchen.oop.exception;

public class TestMethodThrowsExceptionEx1 {

	public void division(int x, int y) throws ArithmeticException, Exception{
		System.out.println("x/y=" + (x/y));
	}
	
	public static void main(String[] args) throws Exception{
		TestMethodThrowsExceptionEx1 exception = new TestMethodThrowsExceptionEx1();
		exception.division(5, 0);
	}

}

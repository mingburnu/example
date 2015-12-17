package tw.leonchen.oop.method;

class Calculator{
	public void add(int x1,int y1){
		System.out.println("x1+y1=" + (x1+y1));
	}
	
	public void minus(int x2,int y2){
		System.out.println("x2-y2=" + (x2-y2));
	}
}

public class CallTestMethodEx1 {

	public static void main(String[] args) {
		Calculator casio = new Calculator();
		casio.add(3, 5);
		casio.minus(5, 12);
		System.out.println("finished");
	}
}

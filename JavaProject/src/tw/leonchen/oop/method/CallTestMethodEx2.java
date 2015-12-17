package tw.leonchen.oop.method;

class TestMethodEx2{
	int time=10;
	int rangePerMinute=30;
	
	public int calculateDistance(){
		return rangePerMinute*time;
	}
}

public class CallTestMethodEx2 {

	public static void main(String[] args) {
		TestMethodEx2 test2 = new TestMethodEx2();
		int num = test2.calculateDistance();
        System.out.println("num=" + num);
	}
}

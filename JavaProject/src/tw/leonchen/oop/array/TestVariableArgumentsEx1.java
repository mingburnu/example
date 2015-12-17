package tw.leonchen.oop.array;

public class TestVariableArgumentsEx1 {

	public void sum(int... num){
		int total=0;
		for(int value:num){
			total=total+value;
		}
		System.out.println("total=" + total);
	}
	
	public static void main(String[] args) {
		TestVariableArgumentsEx1 varargs = new TestVariableArgumentsEx1();
		varargs.sum(1,2,3,4,5,6,7,8,9,10);
	}

}

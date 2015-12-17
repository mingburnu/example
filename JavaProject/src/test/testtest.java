package test;

public class testtest {

	int a=1;   //instance variable
	static int b=2;  //static variable
	
	public void f1(int c){  //local variable
		int d=4;  //local variable
		
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("c=" + c);
		System.out.println("d=" + d);
	}
	
	public static void f2(int e){
		//System.out.println("a=" + a);  //compile error
		System.out.println("b=" + b);  
		//System.out.println("c=" + c);  //compile error
		//System.out.println("d=" + d);  //compile error
		System.out.println("e=" + e);
	}
	
	public static void main(String[] args) {
		testtest scope1 = new testtest();
		scope1.f1(3);
		scope1.a=8;
		scope1.b=15;
		
		scope1.f2(5);
		testtest.f2(6);
		f2(7);
		
		testtest scope2 = new testtest();
		System.out.println("scope2.a=" + scope1.a);
		System.out.println("scope2.b=" + scope2.b);
		
	}

}
package test;

import tw.leonchen.oop.overload.TestOverloadEx1;

public class test8 {

	public test8(){
		System.out.println("run here");
	}
	
	public test8(int num){
		System.out.println("num=" + num);
	}
	
	public void sum(int x, int y){
		System.out.println("(x+y)_1=" + (x+y));
	}
	
	public void sum(double x, double y){
		System.out.println("(x+y)_2=" + (x+y));
	}
	
	public static void main(String[] args) {
		TestOverloadEx1 overload = new TestOverloadEx1();
		overload.sum(10.00,7);
		System.out.println("finished");
		
	}

}

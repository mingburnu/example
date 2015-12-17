package test;

class constructor {

	public constructor(int i) {

		System.out.println("int i=" + i);
	}

	public constructor() {

		System.out.println("no parameter constructor");
	}

	public void voidMethod(int j) {
		System.out.println("voidMethod int j=" + j);
	}

	public void voidNoParameterMethod() {
		System.out.println("void no parameter method");

	}

	public int typeIntReturnMethod(int k) {
		System.out.println("return int k=" + k);
		return k;

	}

}

public class basicFormat {

	public static void main(String[] args) {
		constructor firstType = new constructor(19);
		constructor sencondType = new constructor();
		firstType.voidMethod(25);
		sencondType.voidNoParameterMethod();
		sencondType.typeIntReturnMethod(95);
	}

}

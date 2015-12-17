package tw.leonchen.oop.testpackage.main;

import tw.leonchen.oop.testpackage.compute.TestPackageComputeEx1;
//import tw.leonchen.oop.testpackage.compute.*;

public class CallTestPackageEx1 {

	public static void main(String[] args) {
		TestPackageComputeEx1 compute = new TestPackageComputeEx1();
		double number = compute.calculateMath(2, 5);//math.pow (2^5)
		System.out.println("number=" + number);
	}

}

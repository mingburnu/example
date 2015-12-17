package tw.leonchen.oop;

public class CallTestPackageEx2 {

	public static void main(String[] args) {
		tw.leonchen.oop.testpackage.compute.TestPackageComputeEx1 test = new 
				               tw.leonchen.oop.testpackage.compute.TestPackageComputeEx1();
		double num2 = test.calculateMath(5, 8);
		System.out.println("num2=" + num2);
	}

}

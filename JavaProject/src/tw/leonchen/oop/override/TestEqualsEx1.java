package tw.leonchen.oop.override;

public class TestEqualsEx1 /* extends Object */{

	public boolean equals(Object obj) {
		return true;
	}

	public static void main(String[] args) {
		TestEqualsEx1 test1 = new TestEqualsEx1();
		TestEqualsEx1 test2 = new TestEqualsEx1();

		// boolean a= test1==test2;
		// boolean b= test1.equals(test2);

		System.out.println("(test1==test2)=" + (test1 == test2));
		System.out.println("(test1.equals(test2))=" + (test1.equals(test2)));

		test1 = test2;

		System.out.println("(test1==test2)_1=" + (test1 == test2));
		System.out.println("(test1.equals(test2))_1=" + (test1.equals(test2)));
	}

}

package Check;

import Check.IdCheck;

public class checkMethodTest {

	public static void main(String[] args) {

		IdCheck num = new IdCheck();
		boolean result = num.booleanMethod("B123456789");
		System.out.println(result);
	}

}

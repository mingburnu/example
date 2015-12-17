package tw.leonchen.oop.collections.generics;

import java.util.Enumeration;
import java.util.Vector;

public class TestEnumerationWithVectorEx1 {

	public static void main(String[] args) {
		Vector<String> v1 = new Vector<String>();

		v1.add("ball");
		v1.add("game");
		v1.add("toy");

		Enumeration<String> objs1 = v1.elements();

		while (objs1.hasMoreElements()) {
			String value = objs1.nextElement();
			System.out.println("value=" + value);
		}
	}

}

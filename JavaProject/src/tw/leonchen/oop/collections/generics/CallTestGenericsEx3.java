package tw.leonchen.oop.collections.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CallTestGenericsEx3 {

	public static void main(String[] args) {
		TestGenericsEx1<? extends List> test1;

		test1 = new TestGenericsEx1<ArrayList>();
		test1 = new TestGenericsEx1<Vector>();
	}
}

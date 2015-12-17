package tw.leonchen.oop.collections.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestIteratorWithArrayListEx1 {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();

		list1.add(15);
		list1.add(25);
		list1.add(35);
		list1.add(45);
		list1.add(55);

		Iterator<Integer> i1 = list1.iterator();
		while (i1.hasNext()) {
			System.out.println(i1.next() + 1);
		}

		ListIterator<Integer> li1 = list1.listIterator(3);
		while (li1.hasPrevious()) {
			System.out.println(li1.previous());
		}

		for (Integer obj1 : list1) {
			System.out.println("obj1=" + obj1);
		}
	}

}

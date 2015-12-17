package tw.leonchen.oop.collections;

import java.util.ArrayList;
import java.util.List;

public class TestListEx1 {

	public static void main(String[] args) {
		List list1 = new ArrayList();
        list1.add("mary");
        list1.add("john");
        list1.add(6);
        list1.add(6);
        list1.add(3.14);
        list1.remove("mary");
        System.out.println("list1=" + list1);
	}
}

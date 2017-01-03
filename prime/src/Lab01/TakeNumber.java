package Lab01;

import java.util.HashSet;
import java.util.Set;

public class TakeNumber {

	public static void main(String[] args) {
		int times = 5;
		Set<Integer> set = new HashSet<Integer>();

		while (true) {
			int number = (int) (Math.random()*99)+1;
			set.add(number);
			if(set.size()==times){
				break;
			}
		}
System.out.println(set);
	}
}

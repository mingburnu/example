package tw.leonchen.oop.io;

import java.util.Scanner;

public class TestScannerEx1 {

	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		while(s1.hasNext()){
			System.out.println(s1.next());
		}
        s1.close();
	}

}

package tw.leonchen.oop.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TestFileStreamIOEx1 {

	public static void main(String[] args) throws Exception {
		FileInputStream fis1 = new FileInputStream("d:/temp/hello.txt");
		FileOutputStream fos1 = new FileOutputStream("d:/temp/newHello.txt");  //1.

		int data;
		while ((data = fis1.read()) != -1) {
			System.out.print((char) data);
			fos1.write(data); //2.
		}
		fis1.close();
		fos1.close();  //3.
	}

}

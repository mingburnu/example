package tw.leonchen.oop.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TestFileStreamIOWithBufferedEx1 {
	public static void main(String[] args) throws Exception {
		
		FileInputStream fis1 = new FileInputStream("d:/temp/hello.txt");
		BufferedInputStream bis1 = new BufferedInputStream(fis1);
		
		//BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream("c:/temp/hello.txt"));

		FileOutputStream fos1 = new FileOutputStream("d:/temp/hello_buffered.txt"); 
		BufferedOutputStream bos1 = new BufferedOutputStream(fos1);
		
		//BufferedOutputStream bos1 = new BufferedOutputStream(new FileOutputStream("c:/temp/hello_buffered.txt"));

		int data;
		while ((data = bis1.read()) != -1) {
			System.out.print((char) data);
			bos1.write(data); 
		}
				
		bos1.close();
		fos1.close();
		
		bis1.close();
		fis1.close();		
	}
}

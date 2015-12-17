package tw.leonchen.oop.io;

import java.io.FileInputStream;

public class TestFileInputStreamEx1 {

	public static void main(String[] args) throws Exception{
//		FileInputStream fis1 = new FileInputStream("d:/temp/temp.txt");
		FileInputStream fis1 = new FileInputStream(args[0]);
		int data;
		while((data=fis1.read())!=-1){
			System.out.print((char)data);
		}
		fis1.close();
	}

}

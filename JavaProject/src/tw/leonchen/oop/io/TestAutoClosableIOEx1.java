package tw.leonchen.oop.io;

import java.io.FileReader;

public class TestAutoClosableIOEx1 {

	public static void main(String[] args) {
		try(FileReader fr1 = new FileReader("d:/temp/temp.txt")){
			int data;
			while((data=fr1.read())!=-1){
				System.out.print((char)data);
			}
		}catch(Exception e){			
		}
	}

}

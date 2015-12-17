package test;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import test.TestFileInput;
public class IoTest {

	public static void main(String[] args) {
		//FileReader fr1 = new FileReader("c:/temp/hello.txt");
		/*try{FileReader fr1 = new FileReader("c:/temp/product.txt");
		File input = new File("D:/JavaSource/product.txt");
		TestFileInput DAO =new TestFileInput(input);
		BufferedReader br1 = new BufferedReader(fr1);}
		catch(FileNotFoundException e){}*/
ProductBean p1=new ProductBean("line");
p1.setId(15);

	}

}


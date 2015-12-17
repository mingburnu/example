package tw.leonchen.oop.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class TestFileReaderWriterIOEx1 {

	public static void main(String[] args) throws Exception{
		FileReader fr1 = new FileReader("d:/temp/hello.txt");
		BufferedReader br1 = new BufferedReader(fr1);
		
		FileWriter fw1 = new FileWriter("d:/temp/hello_buffered_char.txt");
		BufferedWriter bw1 = new BufferedWriter(fw1);
		
		String data;
		while((data=br1.readLine())!=null){
			System.out.println(data);
			bw1.write(data);
			bw1.newLine();
		}
		
		bw1.close();
		fw1.close();
		br1.close();
		fr1.close();
	}

}

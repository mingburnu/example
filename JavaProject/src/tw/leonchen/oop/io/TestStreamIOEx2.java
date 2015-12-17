package tw.leonchen.oop.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestStreamIOEx2 {

	public static void main(String[] args) throws Exception {
		System.out.println("Please Input You data:(use Q or q to quit)");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:/temp/streamio.txt")));
		
		String data;
		while((data=br1.readLine())!=null){
			
			if(data.equalsIgnoreCase("Q")){
				bw1.close();
				br1.close();
				System.exit(-1);
			}
			
			System.out.println(data);
			bw1.write(data);
		}
	}

}

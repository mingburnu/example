package tw.leonchen.oop.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestStreamIOEx1 {

	public static void main(String[] args) throws Exception {
		System.out.println("Please Input You data:(use Q or q to quit)");
		InputStream is1 = System.in;
		InputStreamReader isr1 = new InputStreamReader(is1);
		BufferedReader br1 = new BufferedReader(isr1);
		
		String data;
		while((data=br1.readLine())!=null){
			
			if(data.equalsIgnoreCase("Q")){
				System.exit(-1);
			}
			
			System.out.println(data);			
		}
		
		br1.close();
		isr1.close();
		is1.close();
	}

}

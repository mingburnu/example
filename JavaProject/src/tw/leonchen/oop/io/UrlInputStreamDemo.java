package tw.leonchen.oop.io;

import java.io.*;
import java.net.*;

public class UrlInputStreamDemo {

	public static void main(String[] args) {
		try {
			URL url = new URL(args[1]);
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader in = new BufferedReader(isr);
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream("d:/temp/hello_buffered.txt"));
			
			
			System.out.println("----------------------------------------");
			System.out.println(args[0]);
			System.out.println("----------------------------------------");
			String line;
			int data;			
			while ((data = in.read()) != -1) {
				System.out.print((char) data);
				bos.write(data); 
			}
			for (int i = 0; i >= 0; i++) {
				if ((line = in.readLine()) == null) {
					break;
				}				
				
				System.out.println(line);
				 
			}
			bos.close();
			bos.flush();
		} catch (Exception e) {
			System.out.println("error");
		}
	}
}

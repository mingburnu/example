package tw.leonchen.oop.io.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TestNIOFilesCopyEx1 {

	public static void main(String[] args) {
		Path source = Paths.get("d:/temp/hello_nio.txt");
		Path dest = Paths.get("d:/temp/hello.txt");
		
		try {
			Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
			Files.deleteIfExists(source);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		}

	}

}

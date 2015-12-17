package tw.leonchen.oop.io.nio;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestDirectoryStreamEx1 {

	public static void main(String[] args) throws Exception {
		Path dir = Paths.get("d:/temp");
		DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
		
		for(Path path:stream){
			if(Files.isDirectory(path)){
				System.out.println("[" + path.getFileName() + "]");
			}else{
				System.out.println(path.getFileName());
			}
		}
	}

}

package tw.leonchen.oop.io.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;

public class TestFileAttributeEx1 {
	private Path path = Paths.get("d:/temp/hello.txt");

	public void execBasic() throws Exception {
		BasicFileAttributes basic = Files.readAttributes(path,BasicFileAttributes.class);
		System.out.println(basic.isDirectory());
		System.out.println(basic.isRegularFile());
		System.out.println(basic.isOther());
		System.out.println(basic.isSymbolicLink());
	}
	
	public void execDos() throws Exception {
		DosFileAttributes dos = Files.readAttributes(path,DosFileAttributes.class);
		System.out.println(dos.isArchive());
		System.out.println(dos.isHidden());
		System.out.println(dos.isReadOnly());
		System.out.println(dos.isSystem());
	}

	public static void main(String[] args) throws Exception {
		TestFileAttributeEx1 attribute = new TestFileAttributeEx1();
		attribute.execBasic();
		attribute.execDos();
		System.out.println("finished");
	}
}

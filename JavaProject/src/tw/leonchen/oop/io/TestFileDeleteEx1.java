package tw.leonchen.oop.io;

import java.io.File;

public class TestFileDeleteEx1 {

	public static void main(String[] args) {
		File file1 = new File("d:/temp");
		File file2;

		if (file1.exists()) {
			String[] filenames = file1.list();
			for (int i = 0; i < filenames.length; i++) {
				System.out.println("filenames=" + filenames[i]);
				file2 = new File(file1,filenames[i]);
				file2.delete();
			}
			file1.delete();
		}
	}

}

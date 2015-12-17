package tw.leonchen.oop.io;

import java.io.*;

public class BufferedStreamDemo {
	public static void main(String[] args) {
		try {
			byte[] data = new byte[1];
			File srcFile = new File("d:/temp/訂餛系統_DesignSpec.pdf");
			File desFile = new File("d:/temp/hello_buffered.txt");

			BufferedInputStream bufferedInputStream = new BufferedInputStream(
					new FileInputStream(srcFile));
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
					new FileOutputStream(desFile));

			System.out.println("複製檔案：" + srcFile.length() + "位元組");
			while (bufferedInputStream.read(data) != -1) {
				bufferedOutputStream.write(data);
			}

			// 將緩衝區中的資料全部寫出
			bufferedOutputStream.flush();

			// 關閉串流
			bufferedInputStream.close();
			bufferedOutputStream.close();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("using: java UseFileStream src des");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

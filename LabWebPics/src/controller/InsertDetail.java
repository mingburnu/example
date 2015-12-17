package controller;
import java.io.*;
import java.sql.*;

public class InsertDetail {
	public static void main(String[] args) throws Exception {
		File dir = new File("D:/JSP/workspace/LabWebPics/WebContent/picture");
		File[] pictures = dir.listFiles();

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JDBC", "sa", "passw0rd");
		Statement stmt = conn.createStatement();

		int delete = stmt.executeUpdate("delete from detail");
		System.out.println("Delete = "+ delete);
		stmt.close();

		PreparedStatement pstmt = conn.prepareStatement("insert into detail (photoid, photo) values (?, ?)");
		for(int i=0; i<pictures.length; i++) {
			int size = (int) pictures[i].length();
			byte[] content = new byte[size];
			
			FileInputStream fis = new FileInputStream(pictures[i]);
			int readSize = fis.read(content);
			fis.close();

			if(size == readSize) {
				pstmt.clearParameters();
				pstmt.setInt(1, i+1);
				pstmt.setBytes(2, content);
				int insert = pstmt.executeUpdate();

				if(insert==1) {
					System.out.println(pictures[i].getName()+" inserted");
				}
			}
		}
		
		pstmt.close();
		conn.close();
	}
}

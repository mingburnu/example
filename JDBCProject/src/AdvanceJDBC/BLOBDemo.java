package AdvanceJDBC;

import java.sql.*;
import java.io.*;

public class BLOBDemo {
	public static void main(String[] args) {
		Connection conn = null;
		try {     
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=JDBC";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
			
			String qryStmt = "SELECT blobData FROM BlobTest WHERE fileName = ?";
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, args[0]);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String deleteStmt = "DELETE FROM BlobTest WHERE fileName = ?"; 
				stmt = conn.prepareStatement(deleteStmt);
				stmt.setString(1, args[0]);
				stmt.executeUpdate();
				System.out.println("Delete blob is successful!");
			}

			File f = new File(args[0]);
			FileInputStream fis = new FileInputStream(f);
			String insertStmt = "INSERT INTO BlobTest VALUES(?,?)";		
			stmt = conn.prepareStatement(insertStmt);
			stmt.setString(1, args[0]);
			stmt.setBinaryStream(2, fis, (int)f.length());
			stmt.executeUpdate();
			System.out.println("Insert blob is successful!");
	
			f = new File(args[1]);
			stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, args[0]);
			rs = stmt.executeQuery();
			if (rs.next()) {
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
				Blob b = rs.getBlob("blobData");
				byte[] data = b.getBytes(1, (int)b.length());
				bos.write(data, 0, (int)b.length());
				bos.close();
				System.out.println("File output is successful!");
			} // end of if (rs.next())*/ 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class BLOBDemo 

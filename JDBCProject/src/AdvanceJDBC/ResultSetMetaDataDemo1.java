package AdvanceJDBC;

import java.sql.*;

public class ResultSetMetaDataDemo1 {
	public static void main(String[] args) {
		Connection conn = null;
		try {     
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=JDBC";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
			
			String qryStmt = "SELECT * FROM department";
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			ResultSet rs = stmt.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			System.out.println(count);
			for(int i = 1; i <= count; i++) {
				System.out.print(rsmd.getColumnLabel(i) + "(" + rsmd.getColumnType(i) + ", "
					+ rsmd.getColumnTypeName(i)+"), ");
			}
			System.out.print("\n");
			
			while(rs.next()) {
     			for(int i = 1; i <= count; i++)
         			System.out.print(rs.getString(i) + ", ");
     			System.out.print("\n");
			}
		} 
		catch (SQLException e) {
			System.out.println("Vendor code : " + e.getErrorCode());
			
		}catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			if (conn != null)
				try {
					conn.close();
				} catch(Exception e) { e.printStackTrace(); }
		
		}
	}// end of main()
}// end of class ResultSetMetaDataDemo 

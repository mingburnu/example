package BasicJDBC;

import java.sql.*;
/*import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;*/

// Insert one employee
public class InsertDemo1 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=JDBC";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");

			String ins_stmt = "INSERT INTO employee VALUES (?, ?, getDate(), ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(ins_stmt);
			pstmt.setInt(1, 1009);
			pstmt.setString(2, "Jean Tsao");			
			pstmt.setDouble(3, 55000);
			pstmt.setString(4, "100");
			pstmt.setString(5, "senior engineer");
			

			int num = pstmt.executeUpdate();
			System.out.println("insert count = " + num);

			pstmt = conn.prepareStatement("SELECT * FROM employee");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.print("name = " + rs.getString("empname") + ", ");
				System.out.println("salary = " + rs.getDouble("salary"));
				System.out.println("hiredate = " + rs.getDate("hiredate"));
				System.out.println("hiredate = " + rs.getString("hiredate"));
				System.out.println("hiredate = " + rs.getTime("hiredate"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class InsertDemo

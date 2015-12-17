package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class consumerbeanDAO {

	public consumerbeanDAO() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=JDBC;user=sa;password=passw0rd;";
			Connection conn = DriverManager.getConnection(connUrl);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT custid FROM customer");
			while (rs.next()) {
				System.out.println("custid = " + rs.getString("custid"));
			}
	
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

}

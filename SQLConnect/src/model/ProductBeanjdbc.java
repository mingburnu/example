package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductBeanjdbc{
	public static void main(String[] args) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=JDBC;user=sa;password=passw0rd;";
			Connection conn = DriverManager.getConnection(connUrl);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id, name, price FROM Product");

			while (rs.next()) {
				System.out.println("id = " + rs.getString("id"));
				System.out.println("name = " + rs.getString("name"));
				System.out.println("price = " + rs.getString("price"));

				// System.out.println("name = " + rs.getString(1));
				// System.out.println("salary = " + rs.getDouble(2));
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
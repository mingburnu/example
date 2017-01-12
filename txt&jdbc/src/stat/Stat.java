package stat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Stat {

	public static void main(String[] args) throws IOException, SQLException,
			ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager
				.getConnection(
						"jdbc:mysql://192.168.20.71:3306/ebookdb20_mcgrawhill_dev?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8",
						"java_dev_admin", "7UJM9OL.");

		Statement stmt = con.createStatement();

		BufferedReader txtReader = new BufferedReader(new InputStreamReader(
				Stat.class.getResourceAsStream("/stat/Stat")));

		BufferedReader bufferedReader = new BufferedReader(txtReader);

		String line;
		while ((line = bufferedReader.readLine()) != null) {

			// String sql = "SELECT COUNT(*) FROM ebooklog WHERE fk_book_id='"
			// + line.trim()
			// + "'  AND (logType="
			// + "'04'"
			// + " OR logType="
			// + "'05'"
			// + ")"
			// + " AND logDTime > 20110000000000 AND logDTime < 20170000000000";

			// String sql = "SELECT pISBN FROM book WHERE bookID='"
			// + line.trim() + "'";

			String sql = "SELECT name FROM publisher WHERE publisherSerialNo IN (SELECT fk_publisherSerialNo FROM book WHERE bookID= '"
					+ line.trim() + "')";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Object o = rs.getObject(1);
				if (o == null) {
					System.out.println("");
				} else {
					System.out.println(rs.getObject(1).toString().trim());
				}
			}
		}

		txtReader.close();
		con.close();

	}
}

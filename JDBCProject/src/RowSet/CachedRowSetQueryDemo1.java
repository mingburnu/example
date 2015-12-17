package RowSet;

import javax.sql.rowset.*;
import com.sun.rowset.*;

//�۰ʳs�u,����Query,�A�_�u
public class CachedRowSetQueryDemo1 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		CachedRowSet crs = new CachedRowSetImpl();
		crs.setUrl("jdbc:sqlserver://localhost:1433;databaseName=JDBC");
		crs.setUsername("sa");
		crs.setPassword("passw0rd");
		String qryStmt = "SELECT * FROM Stock";
		crs.setCommand(qryStmt);
		crs.execute();//�۰ʳs�u,����Query,�A�_�u

		while(crs.next()) {
			System.out.println("stock symbol = " + crs.getString(1));
			System.out.printf("stock price = %.2f%n", crs.getDouble(2));
 		}
		crs.close();
	}// end of main()
}// end of class CachedRowSetQueryDemo1

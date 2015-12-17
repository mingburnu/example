package ch08.performance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
@WebServlet(
	urlPatterns="/ch08/DataSourceServlet"
)
public class DataSourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DataSourceServlet() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Collection coll =  new ArrayList();
		try {
			HttpSession session = request.getSession();
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDataBase");
			Connection connection = ds.getConnection();
			PreparedStatement pStmt;
			pStmt = connection.prepareStatement("Select * from EmployeeA");
			ResultSet rs = pStmt.executeQuery();
			session.setAttribute("Target", "DS");
			response.sendRedirect("index.jsp");
			connection.close();
			System.out.println("SQL 執行成功");
			return;
		} catch (SQLException e) {
			System.err.println("SQL 執行失敗:"
					+ e.getMessage());
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}

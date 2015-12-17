package ch08.performance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(
	urlPatterns="/ch08/DriverManagerServlet"
)

public class DriverManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DriverManagerServlet() {
      
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");			
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=JSPDB","sa","sa123456");
			PreparedStatement pStmt;
			pStmt = connection.prepareStatement("Select * from EmployeeA");
			ResultSet rs = pStmt.executeQuery();
			session.setAttribute("Target", "DM");
			response.sendRedirect("index.jsp");
			connection.close();
			return ; 
		} catch (SQLException e) {
			System.err.println("SQL 執行失敗:" + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

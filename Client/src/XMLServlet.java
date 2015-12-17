

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * Servlet implementation class XMLServlet
 */
@WebServlet("/XMLServlet")
public class XMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XMLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//http://www.java2s.com/Code/Java/Database-SQL-JDBC/ConvertaResultSettoXML.htm
				PrintWriter out = response.getWriter();
					
				 SAXParserFactory factory = null;
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet rs = null;
				String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Northwind";
				String query = "select CustomerID,CompanyName from Customers where CustomerID like ?";
				String keyword = request.getParameter("term");
				keyword = keyword + "%";
				try{
					DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
					conn = DriverManager.getConnection(url, "sa", "passw0rd");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, keyword);
					
					rs = stmt.executeQuery();
					
					   String xml = "";
		               xml = xml + "<Customers>";
	              
		               while (rs.next())
						 {
		            	     xml = xml + "<Customer>";
							 xml = xml + "<CustomerID>"  + rs.getString(1) + "</CustomerID>";
							 xml = xml + "<CompanyName>"  + rs.getString(2) + "</CompanyName>";
		            	     xml = xml + "</Customer>";
						 }
		               xml = xml + "</Customers>";
		               response.setContentType("text/xml;charset=UTF-8");
			           out.write(xml);
					
				}
				catch(SQLException e){
					out.println("Error:" + e.getMessage());
				}
				finally{
					//if(rs != null){
					//   rs.close();
					//}
					//if(stmt != null){
					// stmt.close();
					//}
					//if(conn != null){
					//}
				}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<%
Connection conn = null;
PreparedStatement stmt = null;
//ResultSet rs = null;
String url = "jdbc:sqlserver://localhost:1433;DatabaseName=JSDB";

String query = "Insert into register2 (LastName ,FirstName) VALUES (?, ?)";

try{

	
	DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
	conn = DriverManager.getConnection(url, "sa", "passw0rd");
	
	stmt = conn.prepareStatement(query);
	
//stmt = conn.prepareStatement("INSERT INTO register2 (LastName ,FirstName) VALUES (?, ?)");
        stmt.setString(1, request.getParameter("name"));
        stmt.setString(2, request.getParameter("street"));
        
        stmt.executeUpdate();
        stmt.close();
        conn.close();


	
		

}
catch(SQLException e){
	out.println("Error:" + e.getMessage());
}
finally{
	
}




%>










   


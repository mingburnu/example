<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*;" %>

<%
Connection conn = null;
PreparedStatement stmt = null;

String url = "jdbc:sqlserver://localhost:1433;DatabaseName=JSDB";

String query = "Insert into register (LastName ,FirstName,Account,Password,BirthDate,Gender,Country,Mobile,BackupEmail,Active)values(?,?,?,?,?,?,?,?,?,?)";

try{
	DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
	conn = DriverManager.getConnection(url, "sa", "passw0rd");
	
	stmt = conn.prepareStatement(query);
	stmt.setString(1, request.getParameter("LastName"));
    stmt.setString(2, request.getParameter("FirstName"));
    stmt.setString(3, request.getParameter("Email"));
    stmt.setString(4, request.getParameter("Password"));
    stmt.setString(5, request.getParameter("BirthDate"));
    stmt.setString(6, request.getParameter("Gender"));
    stmt.setString(7, request.getParameter("CountryCode"));
    stmt.setString(8, request.getParameter("MobileNumber"));
    stmt.setString(9, request.getParameter("BackupEmail"));
    stmt.setString(10, request.getParameter("Active"));   
    int retV=stmt.executeUpdate();
    out.println(retV);
    stmt.close();
    conn.close();		
}
catch(SQLException e){
	out.println("Error:" + e.getMessage());
}





%>
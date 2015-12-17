<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedHashMap"%> 
<%@page import="java.util.Map"%>  
<%@page import="java.util.HashMap"%>
<%@page import="java.util.LinkedList"%>  
<%@page import="java.util.List"%>
<%@page import="org.json.simple.JSONValue"%>
<%@ page import="java.sql.*;" %>

<%
Connection conn = null;
PreparedStatement stmt = null;
ResultSet rs = null;
String url = "jdbc:sqlserver://localhost:1433;DatabaseName=JSDB";
//String url = "jdbc:mysql://localhost:3306/Northwind";
String query = "select OrderID,ProductID,UnitPrice,Quantity,Discount from View_1 where Area=?";
//String query = "select ProductID,UnitPrice,Quantity,Discount from order_details where orderID=?";
String oid = request.getParameter("orderCity");

try{
	DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
	conn = DriverManager.getConnection(url, "sa", "passw0rd");
	//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	//conn = DriverManager.getConnection(url, "root", "123456");
	stmt = conn.prepareStatement(query);
	stmt.setString(1,oid);
	
		
	
	 rs = stmt.executeQuery();
	 List  l1 = new LinkedList();
	 while (rs.next()) {
		 //out.print(rs.getInt(1) + "," + rs.getString(2) + "<br>");
		 Map m1 = new HashMap();       
		 //m1.put("ProductID",new Integer(rs.getInt(1)));   
		 //m1.put("UnitPrice", new Double(rs.getDouble(2))); 
		 //m1.put("UnitPrice",new Integer(rs.getInt(3))); 
		 //m1.put("Discount", new Double(rs.getDouble(4)));
		 m1.put("OrderID",new Integer(rs.getInt(1)));
		 m1.put("ProductID",new Integer(rs.getInt(2)));   
		
		 m1.put("UnitPrice",new Double(rs.getDouble(3))); 
		 m1.put("Quantity",new Integer(rs.getInt(4)));
		  m1.put("Discount", new Float(rs.getDouble(5)));
		 
		 
		 l1.add(m1);
	 }
	 String jsonString = JSONValue.toJSONString(l1);                    
	 out.println(jsonString);
}
catch(SQLException e){
	out.println("Error:" + e.getMessage());
}
finally{
	if(rs != null){
	   rs.close();
	}
	if(stmt != null){
	 stmt.close();
	}
	if(conn != null){
	}
}



// Map m1 = new HashMap();       
// m1.put("name","台北市");   
// m1.put("abbr","TPE"); 

// Map m2 = new HashMap();
// m2.put("name","新北市");   
// m2.put("abbr","TPI");

// Map m3 = new HashMap();
// m3.put("name","桃園縣");   
// m3.put("abbr","TAO");

// Map m4 = new HashMap();
// m4.put("name","新竹縣");   
// m4.put("abbr","HSI");

// Map m5 = new HashMap();
// m5.put("name","基隆市");   
// m5.put("abbr","KEE");

// List  l1 = new LinkedList();
// l1.add(m1);   
// l1.add(m2);   
// l1.add(m3);   
// l1.add(m4); 
// l1.add(m5);

// String jsonString = JSONValue.toJSONString(l1);                    
// out.println(jsonString);
%>
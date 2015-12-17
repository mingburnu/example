<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.gis.DefaultFactory" %>
<%@ page import="com.gis.USER" %>
<%@ page import="org.hibernate.Criteria" %>
<%@ page import="org.hibernate.Transaction" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
try{
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
Session sess= DefaultFactory.getSessionFactory().getCurrentSession();
Transaction tx= sess.beginTransaction();
Criteria criteria= sess.createCriteria(USER.class);
Iterator users = criteria.list().iterator();
while(users.hasNext()) {
USER p = (USER)users.next();
out.print("ID: " + p.getNAME()+"<br/>");
out.print("NAME: " + p.getEMAIL()+"<br/>");
}
tx.commit();
}catch(Exception e){
out.print("Error message: "+ e.getMessage());
}
System.out.print("done.");
%>
</body>
</html>
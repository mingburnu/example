<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Publisher Listing</title>       
    </head>

    <body>
        <h1>StarBooks Publishers</h1>

        <sql:setDataSource var="ds"
            dataSource="jdbc/mydb"
        />
        
        <sql:query var="rs" dataSource="${ds}">
            select * from Publisher
        </sql:query>
        
        <ul>
            <c:forEach var="row" items="${rs.rows}">
               <li><c:out value='${row.publisherName}' /></li> 
            </c:forEach>
        </ul>  
        
    </body>
</html>

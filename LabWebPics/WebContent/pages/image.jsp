<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<title>JSTL sql:query Tag</title>
</head>
<body>

	<sql:setDataSource var="snapshot"
		driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
		url="jdbc:sqlserver://localhost:1433;database=JDBC" user="sa"
		password="passw0rd" />

	<sql:query dataSource="${snapshot}" var="result">
SELECT * from detail;
</sql:query>

	<table border="1" width="100%">
		<tr>
			<th>photo</th>

		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:choose>
						<c:when test="${row.photoid < 10}">
							<img
								src="/LabWebStruts/picture/0<c:out value="${row.photoid}"/>.jpg">
						</c:when>
						<c:otherwise>
							<img
								src="/LabWebStruts/picture/<c:out value="${row.photoid}"/>.jpg">
						</c:otherwise>
					</c:choose></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
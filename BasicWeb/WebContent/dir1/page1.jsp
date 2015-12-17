<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page1</title>
</head>
<body>

<h1>Page1 ${pageContext.request.remoteUser}</h1>
<h3><a href="<c:url value="/index.jsp" />">Home</a></h3>

<%if(request.isUserInRole("Admiral") || request.isUserInRole("Commodore")) {%>
<h3><a href="<c:url value="/dir1/page1.jsp" />">Page1</a></h3>
<%}%>

<%if(request.isUserInRole("Admiral") || request.isUserInRole("Private")) {%>
<h3><a href="<c:url value="/dir2/page2.jsp" />">Page2</a></h3>
<%}%>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="misc.BundleMessage" var="bundle" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/table.css" />" />
<title>Display</title>
</head>
<body>

<h3>Select Product Table Result : ${fn:length(select)} row(s) selected</h3>

<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th><fmt:message bundle="${bundle}" key="display.table.title.id" /></th>
		<th><fmt:message bundle="${bundle}" key="display.table.title.name" /></th>
		<th><fmt:message bundle="${bundle}" key="display.table.title.price" /></th>
		<th><fmt:message bundle="${bundle}" key="display.table.title.make" /></th>
		<th><fmt:message bundle="${bundle}" key="display.table.title.expire" /></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="bean" items="${select}">
		<c:url value="/pages/product.jsp" var="path">
			<c:param name="id" value="${bean.id}" />
			<c:param name="name" value="${bean.name}" />
			<c:param name="price" value="${bean.price}" />
			<c:param name="make" value="${bean.make}" />
			<c:param name="expire" value="${bean.expire}" />
		</c:url>
	<tr>
		<td><a href="${path}">${bean.id}</a></td>
		<td>${bean.name}</td>
		<td><fmt:formatNumber value="${bean.price}" type="currency" /></td>
		<td><fmt:formatDate value="${bean.make}" pattern="yyyy/MM/dd EEEE" /></td>
		<td>${bean.expire}</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</c:if>

<h3><a href="<c:url value="/pages/product.jsp" />">Product Table</a></h3>
</body>
</html>
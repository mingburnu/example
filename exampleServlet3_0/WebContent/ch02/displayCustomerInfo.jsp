<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<H2>${pageContext.request.method} 版(Servlet 3.0)</H2>
親愛的${customer.name}, 您好<P/>
您的Email為${customer.email}<P/> 
您的電話為${customer.tel}<P/>
<c:choose>
   <c:when test="${empty customer.fruits}" >
       您未挑選水果
   </c:when>
   <c:otherwise >
       您挑選的水果有:
       <c:forEach var="fruit" items="${customer.fruits}"> 
          <c:out value="${fruit}" />
       </c:forEach>
   </c:otherwise>
</c:choose>
&nbsp;
<HR>
<CENTER>
<jsp:include page="/commons/segmentch02.jsp"/>
</CENTER>
</body>
</html>
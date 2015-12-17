<%@ page session="false" pageEncoding="UTF-8" errorPage="error/ExceptionPage.jsp" %>
<%-- This page will cause an "divide by zero" exeception --%>

<HTML>

<HEAD>
<TITLE>本網頁會包含其他的網頁片段</TITLE>
</HEAD>

<BODY BGCOLOR='white'>
<TABLE width="600">
<TR><TD><%@ include file="ch03_06_heading.jsp" %></TD></TR>


<TR height="300"><TD>
<H1>本網頁會包含其他的網頁片段</H1>
</TD></TR>
<TR><TD>
<a href='${pageContext.request.contextPath}/ch03'>回第三章</a>
<%@ include file="ch03_06_footing.jsp" %>
</TD></TR>
</TABLE>
</BODY>

</HTML>

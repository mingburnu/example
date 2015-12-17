<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Coffee Catalog</title>
</head>
<BODY BGCOLOR='white'>
	<TABLE BORDER='5' CELLSPACING='5'>
		<TR>
			<TD><TABLE BORDER='0' CELLSPACING='0' CELLPADDING='0'
					bgcolor='eedd82' WIDTH='600'>
					<TR HEIGHT='30'>
						<TD BGCOLOR='#CCCCFF'>&nbsp;</TD>
					</TR>
					<TR>
						<TD BGCOLOR='#CCCCFF' height='60' ALIGN='center' VALIGN='middle'>
							<H3>咖啡目錄</H3>
						</TD>
					</TR>
				</TABLE>
				<TABLE BORDER='2' CELLPADDING='5' WIDTH='600' bgcolor='eedd82'>
					<TR>
						<TH>代號</TH>
						<TH>咖啡</TH>
						<TH>價格</TH>
						<TH>折扣</TH>
					</TR>
					<c:forEach var="list" items="${COFFEE_LIST}">
						<TR>
							<TD style='text-align:right;'>${list.coffeeCode}</TD>
							<TD>${list.coffeeName}</TD>
							<TD style='text-align:right;'>${list.price}</TD>
							<TD style='text-align:center;'>${list.discount}</TD>
						</TR>
					</c:forEach>
				</TABLE></TD></TR></TABLE>
				<br>
				<%
				int yearDay=365;
				int daySeconds=24*60*60;
				int yearSeconds=yearDay*daySeconds;
				long yearMiliSeconds=(long)yearSeconds*1000;
				out.println("一年有:"+yearSeconds+"秒"+"<br>");
				out.println("一年有:"+yearMiliSeconds+"毫秒");
				%>
<BR><BR><font color='red'><small>本畫面直接由JSP產生</small></font>
</BODY>
</HTML>
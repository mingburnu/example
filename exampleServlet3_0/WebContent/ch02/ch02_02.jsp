<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>瀏覽器送出POST命令的時機</title>
</head>
<body bgcolor='#e6e6fa'>
利用表單輸入資料(POST)
<HR>
<h4>Form 標籤的  method 屬性為 POST <BR></h4>
<Form Action="<%= request.getContextPath() %>/ch02/survey.do" method="POST">
      <p/>姓名: <input	type="text" name="userName" value="李大華">
      <p/>EMail: <input type="text" name="eMail" value="user@ppp.com.tw">
      <p/>電話號碼 <input type="text" name="tel">
      <HR>
      請挑選喜歡的水果:<P/>
      <INPUT TYPE='checkbox' NAME='fruit' VALUE='香蕉'> 香蕉 <BR>
      <INPUT TYPE='checkbox' NAME='fruit' VALUE='橘子'> 橘子 <BR>
      <INPUT TYPE='checkbox' NAME='fruit' VALUE='蘋果'> 蘋果 <BR>
      <INPUT TYPE='checkbox' NAME='fruit' VALUE='西瓜'> 西瓜 <BR>
      <INPUT TYPE='checkbox' NAME='fruit' VALUE='梨子'> 梨子 <BR><P/>
      <input type="submit" value="提交">
</Form>
<BR><P/>
<small>&lt;&lt;<a href="index.jsp">回前頁</a>&gt;&gt;</small>
</body>
</html>

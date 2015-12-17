<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>瀏覽器送出GET命令的時機...</title>
</head>
<body bgcolor='#e6e6fa'>
<CENTER>
<TABLE Border='3' width="90%" CELLPADDING='10' BORDERCOLOR='green' bgcolor='#ffe4e1'>
<TR height='80'><TH colspan='2' VALIGN='bottom'><BR><h2>瀏覽器送出GET命令的時機</h2></TH></TR>
<TR>
   <TD width="50%">
      <TABLE >
         <TR height='60'><TH><h3> 1. 在網址列輸入URL，然後按下Enter</h3></TH></TR>
         <TR height='60'><TD>http://192.168.xx.xx:8080/example <BR>(IP 應以實際的IP為主)</TD></TR>
      </TABLE>
   </TD>
   <TD width="50%">
      <TABLE>
         <TR height='60'><TH><h3> 2. 當使用者在網頁內按下某個超連結</h3></TH></TR>    
         <TR height='60'><TD><a href='<%= request.getContextPath() %>/ch01/index.jsp' >第一章首頁</a></TD></TR>
      </TABLE>
   </TD>
</TR>
<TR>
    <TD colspan='2' >
      <TABLE>
         <TR><TH><h3> 3.利用表單輸入資料(GET) ，然後按下submit按鈕</h3></TH></TR>    
         <TR><TD>
            Form 標籤的  method 屬性為 GET <BR>
            <Form Action="../ch02/survey.do" method="GET">
              <p/>姓名: <input	type="text" name="userName" value="李大華">
              <p/>EMail: <input type="text" name="eMail"   value="user@ppp.com.tw">
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
         </TD></TR>
      </TABLE>
    </TD>
</TR>
</TABLE>     
</CENTER>
<P/>
<small>&lt;&lt;<a href="index.jsp">回前頁</a>&gt;&gt;</small>
</body>
</html>
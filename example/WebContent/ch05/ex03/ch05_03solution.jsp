<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD><TITLE>Arithmetic Operations in EL</TITLE></HEAD>
<BODY>
  <CENTER><H1>Arithmetic Operations in EL</H1>
  <TABLE BORDER='1' ALIGN='CENTER' WIDTH='400'>
    <TR>
      <TD WIDTH='300'>\${10 + 5}</TD>
      <TD WIDTH='100'>${10 + 5}</TD>
    </TR>
    <TR>
      <TD WIDTH='300'>\${10 * 5}</TD>
      <TD WIDTH='100'>${10 * 5}</TD>
    </TR>
    <TR>
      <TD WIDTH='300'>\${10 / 5}</TD>
      <TD WIDTH='100'>${10 / 5}</TD>
    </TR>
    <TR>
      <TD WIDTH='300'>\${10 mod 5}</TD>
      <TD WIDTH='100'>${10 mod 5}</TD>
    </TR>
    <TR>
      <TD WIDTH='300'>\${10 + 2 * 5}</TD>
      <TD WIDTH='100'>${10 + 2 * 5}</TD>
    </TR>
    <TR>
      <TD WIDTH='300'>\${(10 + 2) * 5}</TD>
      <TD WIDTH='100'>${(10 + 2) * 5}</TD>
    </TR>
  </TABLE>
  <P/>
  </CENTER>
  <hr>
  客戶端電腦的IP為:${pageContext.request.remoteHost}<br>
  客戶端使用的http方法為:${pageContext.request.method}<br>
  客戶端的瀏覽器為:${header['user-agent']}<br>
  客戶端的瀏覽器送出的請求標頭有:<br>
  <c:forEach var='entry' items='${headerValues}'>
     ${entry.key} ==> 
     <c:forEach items="${entry.value}" varStatus="vs">
      [${vs.index}]: ${entry.value[vs.index]}
    </c:forEach> <br>
  </c:forEach>
  <p/>
  <small>&lt;&lt;<a href="../_ch05.jsp">回第五章首頁</a>&gt;&gt;</small>

</BODY>
</HTML>
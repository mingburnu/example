<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Employee Form</title>
</head>

<body>
   <s:form action="empinfo" method="post">
      <s:textfield name="name" label="Name" size="20" />
      <s:textarea name="age" />
      <s:submit name="submit" label="Submit" align="center" />
   </s:form>
</body>
</html>
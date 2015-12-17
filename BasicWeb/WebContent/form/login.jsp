<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

<h3>Login</h3>

<form action="j_security_check" method="post">
<table>
	<tr>
		<td>ID : </td>
		<td><input type="text" name="j_username"></td>
		<td></td>
	</tr>
	<tr>
		<td>PWD : </td>
		<td><input type="password" name="j_password"></td>
		<td></td>
	</tr>
	<tr>
		<td>　</td>
		<td align="right"><input type="submit" value="Login"></td>
	</tr>
</table>
</form>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@taglib
uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Login Form</title>
</head>
<body>
<h1>${failuremessage}</h1>
<form:form method="POST">
<div align="center">
<table>
<tr>
<td>User Name</td>
<td><input type="text" name="username" /></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password" /></td>
</tr>
<tr>
<td></td>
<td><input formaction="/SampleSpringMVCProject/loginverify" type="submit" value="Login" /></td><td><input formaction="/SampleSpringMVCProject/register" type="submit" value="register" /></td>
</tr>
</table>
<div style="color: red">${error}</div>

</div>
</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password Page</title>
</head>
<body>
	<div align="center">
		<h2>Forgot password?</h2>
		<hr>
		<h4>Enter your email address and we will send you a link to reset
			your password</h4>
		<br> <br>
		<form:form modelAttribute="user"
			action="${pageContext.request.contextPath}/password/processForgotPassword"
			method="POST">
			<table>
				<tr>
					<td>Email : <form:input path="email" />
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
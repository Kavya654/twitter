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
		<h2>Confirm New password</h2>
		<hr>

		<br> <br>
		<form:form modelAttribute="user"
			action="${pageContext.request.contextPath}/password/changePassword"
			method="POST">
			<input type="hidden" value="${token}" name="token"/>

			<table>
				<tr>
					<td>Password : <form:input path="password" />
					</td>
				</tr>

				<tr>
					<td><input type="submit" value="Confirm"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
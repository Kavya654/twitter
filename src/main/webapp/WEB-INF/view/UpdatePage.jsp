<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Update Page</h2>

<form:form action="${pageContext.request.contextPath}/saveUpdatedUser" method="POST" modelAttribute="user">
<input type="hidden" name="id" value="15">
	<table border="1">
		<tr>
			<td>First Name : <form:input path="fname" /></td>
		</tr>
		<tr>
			<td>Last Name : <form:input path="lname" /></td>
		</tr>
		<tr>
			<td>User Name : <form:input path="username" /></td>
		</tr>
		<tr>
			<td>Email : <form:input path="email" /></td>
		</tr>
	</table><br>
	<input type="submit" value="Update">
</form:form>
<br>

<a href="profile?id=15">Back</a>
<br>
<br>

<form:form action="${pageContext.request.contextPath}/logout"
	method="POST">
	<input type="submit" value="LOGOUT">
</form:form>
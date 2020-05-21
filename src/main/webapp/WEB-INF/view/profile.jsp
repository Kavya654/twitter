<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Profile Page</h2>
<table border="1">
	<tr>
		<td>Username</td>
		<td>${user.username }</td>
	</tr>
	<tr>
		<td>First Name</td>
		<td>${user.fname }</td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td>${user.lname }</td>
	</tr>
	<tr>
		<td>Email</td>
		<td>${user.email }</td>
	</tr>


	<tr>
		<td>Followers</td>
		<td>${followers}</td>
	</tr>

	<tr>
		<td>Following</td>
		<td>${following}</td>
	</tr>


</table>
<br>

<form:form action="${pageContext.request.contextPath}/updateProfile"
	method="GET">
	<input type="hidden" name="id" value="15">
	<input type="submit" value="Update">
</form:form>

<br>

<table border="1">
	<tr>
		<th>My Tweets</th>
		<th>Datetime</th>
	</tr>
	<c:forEach var="temp" items="${tweets}">
		<tr>
			<td>${temp.description}</td>
			<td>${temp.datetime }</td>
		</tr>
	</c:forEach>
</table>

<br>
<br>
<c:if test="${!isFollowing}">
	<form:form action="${pageContext.request.contextPath}/followRequest?id=${user.id}"
		method="POST">

			<input type="submit" value="Follow">

	</form:form>
</c:if>

<c:if test="${isFollowing}">
	<form:form action="${pageContext.request.contextPath}/unFollowRequest?id=${user.id}"
		method="POST">
		<input type="submit" value="UnFollow">

	</form:form>
</c:if>

<a href="feed">Back</a>
<br>
<br>

<form:form action="${pageContext.request.contextPath}/logout"
	method="POST">

	<input type="submit" value="LOGOUT">

</form:form>
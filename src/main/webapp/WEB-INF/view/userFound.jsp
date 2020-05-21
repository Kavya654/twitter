<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>

	<h2>List Of Users</h2>

	<table border="1">
    	<tr>

    		<th>Username</th>
    		<th>Email</th>
    		<th>Profile</th>
    	</tr>
    	<c:forEach var="temp" items="${user}">
    		<tr>
    			<td>${temp.username}</td>
    			<td>${temp.email}</td>
    			<td><a href="profile?id=${temp.id}">Profile</a></td>
    		</tr>
    	</c:forEach>
    </table>
    <br><br>

    <a href="feed">Back</a>
        <br><br>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="LOGOUT">
	</form:form>



</body>
</html>
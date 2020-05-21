<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up Page</title>
<style>
.error{
	color:red;
}
</style>
</head>
<body>

       <h2> Register Page</h2>
        <form:form modelAttribute="user" action="${pageContext.request.contextPath}/addUser?error" method="POST">
        	<form:hidden path="id"/>
        		<table>
        			<tr>
        				<td>First Name : <form:input path="fname" />
        				</td>
        				<td><form:errors path="fname" cssClass="error"/></td>
        			</tr>
        			<tr>
        				<td>Last Name : <form:input path="lname" /></td>
        				<td><form:errors path="lname" cssClass="error"/></td>
        			</tr>
        			<tr>
                        <td>User Name : <form:input path="username" />
                        </td>
                        <td><form:errors path="username" cssClass="error"/></td>
                    </tr>
        			<tr>
        				<td>Email : <form:input path="email" />
        				</td>
        				<td><form:errors path="email" cssClass="error"/></td>
        			</tr>
        			<tr>
        				<td>Password : <form:password path="password" />
        				</td>
        				<td><form:errors path="password" cssClass="error"/></td>
        			</tr>
        			<tr>
        				<td><input type="submit" value="Register"></td>
        			</tr>
        		</table>
        	</form:form>

</body>
</html>
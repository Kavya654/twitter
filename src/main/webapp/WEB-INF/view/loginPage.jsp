<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Welcome Page</title>
</head>
<body>
    <p align="center">Login Page</p>
        <div align="center">
            <form:form action="${pageContext.request.contextPath}/authenticateTheUser" modelAttribute="user" method="POST">
                           <input type="hidden" name="id" value="1">
                username : <input type="text" name="username"><br>
                password : <input type="password" name="password"><br><br>
                            <input type="submit" value="Submit">
            </form:form>
        </div>

     <p align="center">No Account?<a href="register"> Sign Up</a></p>
     <p align="center">Forgot Password?<a href="${pageContext.request.contextPath}/password/forgotPassword"> Click here </a></p>

</body>
</html>
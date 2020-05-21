<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h2> Tweet Page</h2>
        <form:form modelAttribute="tweet" action="${pageContext.request.contextPath}/addTweet" method="POST">
        	<form:hidden path="id"/>
        Tweet  : <input type="text" name="description"><br>
                 <input type="submit" value="Create">
                 </form:form>

                 <a href="feed">Back</a>
                 <br><br>

                 <form:form action="${pageContext.request.contextPath}/logout" method="POST">

                 	<input type="submit" value="LOGOUT">

                 </form:form>
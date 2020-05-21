<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>Twitter Feeds</h3>

<a href="profile?id=15">My Profile</a>
<br>
<br>
<a href="createTweet">Tweet</a>
<br>
<br>


<form:form action="/searchUser" method="GET">

Search : <input type="text" name="username" value="${name}">
		 <input type="submit" value="Search">
	<br>
</form:form>

<table border="1">

	<tr>
		<th>Username</th>
		<th>Tweet</th>
		<th>Date & Time</th>
	</tr>
	<c:forEach var="temp" items="${tweets}">

		<tr>
			<td>${temp.username}</td>
			<td>${temp.description}</td>
			<td>${dateFormater.format(temp.datetime)}</td>
		</tr>
	</c:forEach>

</table>

<br><br>

<c:forEach var="index" begin="0" end="${page.getTotalPages()-1}">
		<c:if test="${index == page.getNumber()}">
			<b>${index + 1}</b>
		</c:if>
		<c:if test="${index != page.getNumber()}">
			<a href="/feed?page=${index}">${index + 1}</a>
		</c:if>
	</c:forEach>
<br>
<br>


<form:form action="${pageContext.request.contextPath}/logout"
	method="POST">
	<input type="submit" value="LOGOUT">
</form:form>


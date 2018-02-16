<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>
<body>
	<h2>Spring Security 4</h2>
	<hr />
	<h3>User dashboard</h3>
	
	<security:authorize access="isAuthenticated()">
		<b>Welcome! <security:authentication property="principal.username" /></b>
	</security:authorize>
	<br />
	
	<security:authorize access="isAuthenticated()">
		<a href="${contextPath}/">Home</a> | <a href="logout">Logout</a>
	</security:authorize>
</body>
</html>
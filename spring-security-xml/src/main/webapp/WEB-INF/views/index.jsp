<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>index</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>
<body>
	<h2>Spring Security 4</h2>
	<hr />
	
	<h3>
		Welcome ! <%-- <c:out value="${pageContext.request.remoteUser}"/> --%>
		<security:authorize access="isAnonymous()"> Guest</security:authorize>
		<!-- Print the logged in user name -->
		<security:authorize access="isAuthenticated()">
			<security:authentication property="principal.username" />
		</security:authorize>
	</h3>
	
	<security:authorize access="isAnonymous()">
    	Login as <a href="${contextPath}/user">User</a> or <a href="${contextPath}/admin">Admin</a>
	</security:authorize>
	
	<security:authorize access="isAuthenticated()">
		<security:authorize access="hasRole('USER')">
			<a href="${contextPath}/user">My Profile</a>
		</security:authorize>
		
		<security:authorize access="hasRole('ADMIN')">
			<a href="${contextPath}/admin">My Profile</a>
		</security:authorize>
		
		<a href="${contextPath}/logout">Logout</a>
	</security:authorize>
</body>
</html>
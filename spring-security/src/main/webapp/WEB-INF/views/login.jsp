<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box{
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}

h4{
	text-align: center;
}
</style>
</head>
<body>
	<div id="login-box">		
		<h4>Login Form</h4>
	
		<form action='<spring:url value="/signin"/>' method="post">
			<table>
				<tr>
					<td>Username</td>
					<td><input type="text" name="userid"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="passwd"></td>
				</tr>
				<tr>
					<td><button type="submit">Login</button></td>
				</tr>
			</table>
		</form>
		<br />
		<c:if test="${not empty sessionScope.message}">
			<div class="error"><c:out value="${sessionScope.message}" /></div>
			<c:remove var="message" scope="session" />
		</c:if>
	</div>
</body>
</html>
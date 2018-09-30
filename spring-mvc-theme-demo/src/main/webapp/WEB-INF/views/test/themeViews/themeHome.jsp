<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><spring:message code="label.title" /></title>
	
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

	<link href="${contextPath}/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	
	<spring:theme code="css" var="themeName" />
	<link href='<spring:url value="/resources/${themeName}"/>' rel="stylesheet" type="text/css"/>
</head>
<body>

   <div role="main" class="container">
      <div class="jumbotron">
         <h1>Spring MVC 5</h1>
         <p class="lead">This is an example of using theme resolver in Spring MVC.</p>


         <div class="dropdown">
            <button class="btn btn-danger dropdown-toggle" type="button" id="dropdownMenuButton"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Change Theme</button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
               <a class="dropdown-item" href="?theme=cerulean">Cerulean</a>
               <a class="dropdown-item" href="?theme=pulse">Pulse</a>
            </div>
         </div>

      </div>
   </div>
   
	<script src="${contextPath}/webjars/jquery/3.2.1/jquery.min.js"></script>
	<script src="${contextPath}/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</body>
</html>
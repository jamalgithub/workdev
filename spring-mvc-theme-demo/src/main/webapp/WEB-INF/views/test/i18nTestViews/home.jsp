<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><spring:message code="label.title" /></title>
</head>
<body>
	<h1><spring:message code="logo.title"/></h1>

    <a href="?locale=en" title='<spring:message code="label.en" />'><img alt="" src='<c:url value="/resources/uk_32.png" />'></a>
    <a href="?locale=fr" title='<spring:message code="label.fr" />'><img alt="" src='<c:url value="/resources/fr_32.png" />'></a>
    <a href="?locale=es" title='<spring:message code="label.es" />'><img alt="" src='<c:url value="/resources/es_32.png" />'></a>

    <p>${message}</p>

    <p><spring:message code="welcome.greeting" arguments="${startMeeting}"/></p>

    <spring:message code="label.current"/> : ${pageContext.response.locale} / ${locale}
</body>
</html>
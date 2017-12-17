<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<html>
<head>
<title><spring:message code="label.title" /></title>
</head>
<body>
	<a href="?locale=en" title='<spring:message code="label.en" />'><img alt="" src='<c:url value="/resources/image/uk_32.png" />'></a><a href="?locale=fr" title='<spring:message code="label.fr" />'><img alt="" src='<c:url value="/resources/image/fr_32.png" />'></a><a href="?locale=es" title='<spring:message code="label.es" />'><img alt="" src='<c:url value="/resources/image/es_32.png" />'></a>
	
	<form method="post" action="login">
		<table>
			<tr>
				<td><label><strong><spring:message code="label.firstName" /></strong></label></td>
				<td><input name="firstName" /></td>
			</tr>
			<tr>
				<td><label><strong><spring:message code="label.lastName" /></strong></label></td>
				<td><input name="lastName" /></td>
			</tr>
			<tr>
				<spring:message code="label.submit" var="labelSubmit"></spring:message>
				<td colspan="2"><input type="submit" value="${labelSubmit}" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
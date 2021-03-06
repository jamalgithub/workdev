<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
	<title>Customer Registration Form</title>
	
	<spring:url value="/resources/css/style.css" var="mainCSS" />
	<link href="${mainCSS}" rel="stylesheet" />
</head>
<body>

<i>Fill out the form. Asterisk (*) means required.</i>
<br><br>

	<form:form action="processForm" modelAttribute="customer">
	
		First name: <form:input path="firstName" />
		
		<br><br>
		
		Last name (*): <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		
		<br><br>

		<input type="submit" value="Submit" />
				
	</form:form>

</body>

</html>
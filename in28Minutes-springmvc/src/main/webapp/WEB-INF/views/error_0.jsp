<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	Application has encountered an error. Please contact support on ...<br>
	<p>
		status: <%=response.getStatus()%>
	</p>
	<p>
		Exception Message: ${exception.message}
	</p>
	<p>
		Exception type: ${exception['class'].name}
	</p>
</div>

<%@ include file="common/footer.jspf"%>
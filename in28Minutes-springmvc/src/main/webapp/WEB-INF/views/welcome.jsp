<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<spring:message code="welcome.message" /> ${name}. <br>You are now authenticated.<br>You can <a href="/todo/list-todos">manage your todos</a>
</div>

<%@ include file="common/footer.jspf"%>
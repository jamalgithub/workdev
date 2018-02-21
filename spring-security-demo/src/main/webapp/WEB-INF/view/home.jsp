<%@ include file="common/header.jspf"%>

<h2>luv2code Company Home Page</h2>
<hr>

<p>
Welcome to the luv2code company home page!
</p>

<hr>
	
<!-- display user name and role -->
<p>
	User: <security:authentication property="principal.username" />
	<br><br>
	Role(s): <security:authentication property="principal.authorities" />
</p>

<hr>

<security:authorize access="hasRole('MANAGER')">

	<!-- Add a link to point to /leaders ... this is for the managers -->	
	<p>
		<a href="${contextPath}/leaders">Leadership Meeting</a>
		(Only for Manager peeps)
	</p>
	
</security:authorize>

<security:authorize access="hasRole('ADMIN')">

	<!-- Add a link to point to /systems ... this is for the admins -->	
	<p>
		<a href="${contextPath}/systems">IT Systems Meeting</a>
		(Only for Admin peeps)
	</p>
	
</security:authorize>

<hr>
	
<!-- Add a logout button -->
<form:form action="${contextPath}/logout" method="POST">

	<input type="submit" value="Logout" />

</form:form>
	
<%@ include file="common/footer.jspf"%>
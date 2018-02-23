<%@ include file="common/header.jspf"%>

<h3>Fitness Tracker Custom Login Page</h3>

<!-- Check for login error -->

<c:if test="${param.error != null}">
	<div class="errorblock">
		<i>Sorry! You entered invalid username/password.</i>
	</div>
</c:if>

<!-- Check for logout -->
	
<c:if test="${param.logout != null}">
	            
	<div class="alert alert-success col-xs-offset-1 col-xs-10">
		You have been logged out.
	</div>
   
</c:if>

<form:form action="${contextPath}/loginAction.html" name="f" method="post">
	<table>
		<tr> 
			<td>User:</td>
			<td><input type="text" name="username" value=""></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password" ></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" name="Submit" value="Submit"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="reset" name="reset" > </td>
		</tr>	
	</table>

</form:form>

<%@ include file="common/footer.jspf"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<form action="/login.do" method="post">
		<p>
			<font color="red">${errorMessage}</font>
		</p>
		Name: <input type="text" name="name" /> Password:<input	type="password" name="password" />
		<input type="submit" value="Login" />
	</form>

</div>

<footer class="footer">
	<div>footer content</div>
</footer>

<script src="${contextPath}/webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="${contextPath}/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

<%@ include file="common/footer.jspf"%>
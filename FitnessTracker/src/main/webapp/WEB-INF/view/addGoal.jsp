<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div>
		<h1>Add Goal</h1>
		<p>Add your workout goal in minutes for the day. <br> &nbsp;</p>
	</div>

	<form:form modelAttribute="goal">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<form:label path="minutes"> Enter Minutes: </form:label>
		<form:input path="minutes" cssErrorClass="error" />
		<form:errors path="minutes" cssClass="error" />
		<br />
		<input type="submit" class="btn" value="Enter Goal Minutes" />
	</form:form>

	<div class="control-group"></div>
</div>

<%@ include file="common/footer.jspf"%>

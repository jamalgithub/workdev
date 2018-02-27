<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div>
		<h1>
			<spring:message code="minutes.exercised" />
		</h1>
	</div>
	<a class="btn" href="?language=en"> English </a> 
	<a class="btn" href="?language=es"> Spanish </a> <br /><br />
	
	<form:form modelAttribute="exercise">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<div class="control-group">
			<form:label path="minutes"><spring:message code="minutes.text" /></form:label>
			<form:input path="minutes" />
			<form:errors path="minutes" cssClass="error" />
		</div>

		<div class="control-group">
			<form:label path="activity"><spring:message code="minutes.activity" /></form:label>
			<form:select id="activities" path="activity" />
		</div>

		<input type="submit" class="btn" value="<spring:message code="minutes.button.enter"/>" />

	</form:form>

	<span class="label"> <spring:message code="minutes.goal" />
		${goal.minutes}
	</span>
</div>

<%@ include file="common/footer.jspf"%>

<script type="text/javascript">
	$("body").css("padding-top", "60px");
	
	$(document).ready(
		function() {
			$.getJSON(
				'<spring:url value="activities.json"/>',
				{
					ajax : 'true'
				},
				function(data) {
					var html = '<option value="">--Please select one--</option>';
					var len = data.length;
					for (var i = 0; i < len; i++) {
						html += '<option value="' + data[i].desc + '">'
								+ data[i].desc
								+ '</option>';
					}
					html += '</option>';

					$('#activities').html(html);
				});
		}
	);
</script>





















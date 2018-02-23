<%@ include file="WEB-INF/view/common/header.jspf"%>
<%@ include file="WEB-INF/view/common/navigation.jspf"%>

<div class="container">
	<div class="hero-unit">
		<div>
			<h1>
				Welcome to Fitness Tracker 
				<%-- <c:out value="${pageContext.request.remoteUser}"/> --%>
				<security:authentication property="principal.username"/>
				!
			</h1>
			<p>To get started, we need to enter a goal for what we want to
				exercise for today.</p>
		</div>
		
		<a class="btn btn-primary" href="${contextPath}/addGoal"> Add Goal » </a>
		
		<security:authorize access="hasRole('ADMIN')">
        	<a class="btn btn-primary" href="${contextPath}/editGoal">Edit Goal »</a>
        </security:authorize>
        
		<a class="btn btn-primary" href="${contextPath}/addMinutes"> Add Exercise	Minutes » </a>
		<a class="btn btn-warning" href="${contextPath}/logout">Logout >></a>
	</div>
	<div></div>
</div>

<%@ include file="WEB-INF/view/common/footer.jspf"%>

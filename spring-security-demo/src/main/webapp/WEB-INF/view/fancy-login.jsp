<%@ include file="common/header.jspf"%>

<div>
	<div class="container"> 
		<div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Sign In</div>
				</div>
	
				<div style="padding-top: 30px" class="panel-body">
	
					<!-- Login Form -->
					<form:form action="${contextPath}/authenticateTheUser" method="POST" class="form-horizontal">
	
					    <!-- Place for messages: error, alert etc ... -->
					    <div class="form-group">
					        <div class="col-xs-15">
					            <div>
										
									<!-- Check for login error -->
		
									<c:if test="${param.error != null}">
	
										<div class="alert alert-danger col-xs-offset-1 col-xs-10">
											Invalid username and password.
										</div>
									
									</c:if>
									
									<!-- Check for logout -->
	
									<c:if test="${param.logout != null}">
										            
										<div class="alert alert-success col-xs-offset-1 col-xs-10">
											You have been logged out.
										</div>
								    
									</c:if>																										
	
					            </div>
					        </div>
					    </div>
	
						<!-- User name -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							
							<input type="text" name="username" placeholder="username" class="form-control">
						</div>
	
						<!-- Password -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							
							<input type="password" name="password" placeholder="password" class="form-control" >
						</div>
	
						<!-- Login/Submit Button -->
						<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-success">Login</button>
							</div>
						</div>
						
						<!-- Add CSRF token manually if we don't use spring form tag form:form -->
	
						<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
					</form:form>
				</div>
			</div>	
		</div>
	</div>
	
	<!-- <div class="container">
			
		Stack the columns on mobile by making one full-width and the other half-width
		<div class="row">
			<div class="col-xs-12 col-md-8 bg-primary">.col-xs-12 .col-md-8</div>
			<div class="col-xs-6 col-md-4 bg-primary">.col-xs-6 .col-md-4</div>
		</div>
		
		Columns start at 50% wide on mobile and bump up to 33.3% wide on desktop
		<div class="row">
			<div class="col-xs-6 col-md-4 bg-danger">.col-xs-6 .col-md-4</div>
			<div class="col-xs-6 col-md-4 bg-danger">.col-xs-6 .col-md-4</div>
			<div class="col-xs-6 col-md-4 bg-danger">.col-xs-6 .col-md-4</div>
		</div>
		
		Columns are always 50% wide, on mobile and desktop
		<div class="row">
			<div class="col-xs-6 bg-success">.col-xs-6</div>
			<div class="col-xs-6 bg-success">.col-xs-6</div>
		</div>
	</div> -->

</div>

<%@ include file="common/footer.jspf"%>
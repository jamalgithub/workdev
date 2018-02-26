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
					<c:url var="loginUrl" value="/loginAction" />
					<form:form action="${loginUrl}" method="POST" class="form-horizontal">
	
					    <!-- Place for messages: error, alert etc ... -->
					    <div class="form-group">
					        <div class="col-xs-15">
					            <div>
										
									<!-- Check for login error -->
		
									<c:if test="${param.error != null}">
	
										<div class="alert alert-danger col-xs-offset-1 col-xs-10">
											<p><i>Invalid username and password.</i></p>
										</div>
									
									</c:if>
									
									<!-- Check for logout -->
	
									<c:if test="${param.logout != null}">
										            
										<div class="alert alert-success col-xs-offset-1 col-xs-10">
											<p>You have been logged out successfully.</p>
										</div>
								    
									</c:if>																										
	
					            </div>
					        </div>
					    </div>
	
						<!-- User name -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							
							<input id="username" type="text" name="username" placeholder="username" class="form-control">
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
	
</div>

<%@ include file="common/footer.jspf"%>

<script type="text/javascript">
	$( document ).ready(function() {
		$( "#username" ).focus();
	});
</script>
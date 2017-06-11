<div class="container">
	<div class="row">
		<div class="col-md-offset-5 col-md-3">
			<div class="form-login">
				<h4>
					<span class="label label-danger">${requestScope.message}</span>
				</h4>
				<h4>Login</h4>
				<form id='loginForm'
					action="<%=request.getContextPath()%>/RequestHandler" method="post">
					<input type="hidden" name="function" value="update"> <input
						type="text" id="userId" name="userIde"
						class="form-control input-sm chat-input" placeholder="username" />
					<input type="text" id="lastName" name="lastName"
						class="form-control input-sm chat-input" placeholder="username" />
					<div class="wrapper">
						<button type="button" class="btn btn-default">Search</button>
					</div>
				</form>
			</div>

		</div>
	</div>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
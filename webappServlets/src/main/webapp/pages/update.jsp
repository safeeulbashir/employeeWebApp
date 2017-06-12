<%@page import="webappservice.EmployeeServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Bare - Start Bootstrap Template</title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Custom CSS -->
<style>
body {
	padding-top: 70px;
	/* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
}
</style>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript">
	function validateform() {
		var userID = document.getElementById('userID').value;
		if (userID == '') {
			alert('please enter user id');
			return false;
		}
		document.getElementById('employeeDisplayForm').submit();
		/* document.getElementById("EmployeeDisplayer").setAttribute("style", "display: block;"); */

	}
	function validateUpdateform() {
		if (document.getElementById('userFirstName').value == ''
				|| document.getElementById('userLastName').value == ''
				|| document.getElementById('userSalary'))
			return false;
		document.getElementById('employeeUpdateForm').submit();
	}
</script>

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Welcome</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a
						href="<%=request.getContextPath()%>/RequestHandler?requestAction=VIEW_EMPLOYEE">View
							Employee</a></li>
					<li><a
						href="<%=request.getContextPath()%>/RequestHandler?requestAction=UPDATE_EMPLOYEE">Update
							Employee</a></li>
					<li><a
						href="<%=request.getContextPath()%>/RequestHandler?requestAction=GENERATE_EMPLOYEE">Add
							Employee</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->
<div class="container">
	<div class="row">
		<div class="col-md-offset-5 col-md-3">
			<div class="form-login">
				<h4></h4>
				<h4>Display Employee</h4>
				<form id='employeeDisplayForm' action="EmployeeRequestHandler"
					method="get" onsubmit="return validateform()">
					<input type="hidden" name="function" value="displayForUpdate">
					<input type="text" id="userID" name="userID"
						class="form-control input-sm chat-input" placeholder="User ID" />
					<div class="wrapper">
						<input type="submit" id="submit" class="btn btn-default"
							value="Search">
					</div>
			</div>
			</form>
		</div>

	</div>
</div>
<div class="container" id="EmployeeDisplayer">
	<div class="row">
		<div class="col-md-offset-5 col-md-3">
			<div class="form-login">
				<form id='employeeUpdateForm' action="EmployeeRequestHandler"
					method="get" style="display: 'none';"
					onsubmit="return validateUpdateform()">
					<input type="hidden" name="function" value="updateRequest">
					<table>
						<tr>
							<td class="span4">Employee ID:</td>
							<td class="span3">${requestScope.employeeInformation.getEmpNo()}
								<input type="hidden" id="userUpdateID" name="userUpdateID"
								class="form-control input-sm chat-input" placeholder="User ID"
								value=${requestScope.employeeInformation.getEmpNo()}>
							</td>

						</tr>
						<tr>
							<td>First Name:</td>
							<td class="span4"><input type="text" id="userFirstName"
								name="userFirstName" class="form-control input-sm chat-input"
								placeholder="First Name"
								value="${requestScope.employeeInformation.getFirstName()}" /></td>

						</tr>
						<tr>
							<td>Last Name:</td>
							<td><input type="text" id="userL" name="userLastName"
								class="form-control input-sm chat-input" placeholder="Last Name"
								value="${requestScope.employeeInformation.getLastName()}" /></td>

						</tr>
						<tr>
							<td>Department Name:</td>
							<td>${requestScope.employeeInformation.getDeptartmentName()}<input
								type="hidden" id="userDepartment" name="userDepartment"
								class="form-control input-sm chat-input"
								placeholder="userDepartment"
								value=${requestScope.employeeInformation.getDeptartmentName() } /></td>
						</tr>
						<tr>
							<td>Salary</td>
							<td><input type="text" id="userSalary" name="userSalary"
								class="form-control input-sm chat-input" placeholder="Salary"
								value="${requestScope.employeeInformation.getSalary()}" /></td>
						</tr>
						<tr>
							<td>Joining Date</td>
							<td>${requestScope.employeeInformation.getJoinDate() }<input
								type="hidden" id="userJoiningDate" name="userJoiningDate"
								class="form-control input-sm chat-input"
								placeholder="Joining Date"
								value="${requestScope.employeeInformation.getJoinDate()}" /></td>
						</tr>
						<tr colspan="2">
							<td><input type="submit" id="submit" class="btn btn-default"
								value="Update"></td>
						</tr>
					</table>
				</form>
				<span class="label label-success">${requestScope.message}</span>
			</div>

		</div>
	</div>

</body>
</html>

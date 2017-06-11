<%@page import="webappservice.EmployeeServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
</head>
<script type="text/javascript">
	function validateform() {
		var userID = document.getElementById('userID').value;
		if (userID == '') {
			alert('please enter user id');
			return false;
		}

		document.getElementById('employeeDisplayForm').submit();
	}
</script>
<div class="container">
	<div class="row">
		<div class="col-md-offset-5 col-md-3">
			<div class="form-login">
				<h4></h4>
				<h4>Display Employee</h4>
				<form id='employeeDisplayForm' action="EmployeeRequestHandler"
					method="get" onsubmit="return validateform()">
					<input type="hidden" name="function" value="display"> <input
						type="text" id="userID" name="userID"
						class="form-control input-sm chat-input" placeholder="userID" />
					<div class="wrapper">
						<input type="submit" id="submit" class="btn btn-default"
							value="Search">
					</div>
			</div>
			</form>
		</div>

	</div>
</div>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Joining Date</th>
			<th>Department</th>
			<th>Salary</th>
			<th>Gross Salary</th>

		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${requestScope.employeeInformation.getEmpNo()}</td>
			<td>${requestScope.employeeInformation.getEmpName()}</td>
			<td>${requestScope.employeeInformation.getJoinDate()}</td>
			<td>${requestScope.employeeInformation.getDeptartmentName()}</td>
			<td>${requestScope.employeeInformation.getSalary()}</td>
			<td>${requestScope.employeeInformation.calculateGrossSalary()}</td>
		</tr>
	</tbody>
</table>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>


</body>
</html>
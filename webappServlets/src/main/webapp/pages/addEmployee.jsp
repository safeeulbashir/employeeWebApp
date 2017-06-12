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
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
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
<div class="container">
	<div class="row">
		<div class="col-md-offset-5 col-md-3">
			<div class="form-login">
				<h4></h4>
				<h4>Generate EmployeeID</h4>
				<form id='generateEmployeeID' action="EmployeeRequestHandler"
					method="get">
					<input type="hidden" name="function" value="generateEmployeeID">
					<div class="wrapper">
						<input type="submit" id="submit" class="btn btn-default"
							value="Generate Employee ID">
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
				<form id='employeeAddForm' action="EmployeeRequestHandler"
					method="get" style="display: 'none';"
					onsubmit="return validateUpdateform()">
					<input type="hidden" name="function" value="addRequest">
					<table>
						<tr>
							<td class="span4">Employee ID:</td>
							<td class="span3">${requestScope.employeeId}<input
								type="hidden" id="userUpdateID" name="userUpdateID"
								class="form-control input-sm chat-input" placeholder="User ID"
								value=${requestScope.employeeId}>
							</td>

						</tr>
						<tr>
							<td>First Name:</td>
							<td class="span4"><input type="text" id="userFirstName"
								name="userFirstName" class="form-control input-sm chat-input"
								placeholder="First Name" value='' /></td>

						</tr>
						<tr>
							<td>Last Name:</td>
							<td><input type="text" id="userL" name="userLastName"
								class="form-control input-sm chat-input" placeholder="Last Name"
								value='' /></td>

						</tr>
						<tr>
							<td>Date of Birth:</td>
							<td><input type="text" id="dateOfBirth" name="dateOfBirth"
								class="form-control input-sm chat-input"
								placeholder="Date of Birth" value='' /></td>
						</tr>
						<tr>
							<td>Date of Hire</td>
							<td><input type="text" id="hireDate" name="hireDate"
								class="form-control input-sm chat-input" placeholder="Hiring Date"
								value='' /></td>
						</tr>
						<tr>
							<td>Gender</td>
							<td><input type="text" id="gender" name="gender"
								class="form-control input-sm chat-input" placeholder="M/F"
								value='' /></td>
						</tr>
						<tr colspan="2">
							<td><input type="submit" id="submit" class="btn btn-default"
								value="Add Employee"></td>
						</tr>
					</table>
				</form>
				<span class="label label-success">${requestScope.message}</span>
			</div>

		</div>
	</div>

	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>


	</body>
</html>
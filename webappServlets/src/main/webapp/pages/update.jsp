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
	function validateUpdateform()
	{
		if(document.getElementById('userFirstName').value=='' ||
			document.getElementById('userLastName').value==''||
			document.getElementById('userSalary'))
			return false;
		document.getElementById('employeeUpdateForm').submit();
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
					<input type="hidden" name="function" value="displayForUpdate">
					<input type="text" id="userID" name="userID"
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
<form id='employeeUpdateForm' action="EmployeeRequestHandler"
	method="get" style="display: 'none';" onsubmit="return validateUpdateform()">
	<input type="hidden" name="function" value="updateRequest">
	<table>
		<tr>
			<td class="span4">Employee ID:</td>
			<td class="span3">${requestScope.employeeInformation.getEmpNo()}
				<input type="hidden" id="userUpdateID" name="userUpdateID"
				class="form-control input-sm chat-input" placeholder="userUpdateID"
				value=${requestScope.employeeInformation.getEmpNo()}>
			</td>

		</tr>
		<tr>
			<td>First Name:</td>
			<td class="span4"><input type="text" id="userFirstName"
				name="userFirstName" class="form-control input-sm chat-input"
				placeholder="userFirsName"
				value=${requestScope.employeeInformation.getFirstName() } /></td>

		</tr>
		<tr>
			<td>Last Name:</td>
			<td><input type="text" id="userL" name="userLastName"
				class="form-control input-sm chat-input" placeholder="userLastName"
				value=${requestScope.employeeInformation.getLastName() } /></td>

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
				class="form-control input-sm chat-input" placeholder="userSalary"
				value=${requestScope.employeeInformation.getSalary() } /></td>
		</tr>
		<tr>
			<td>Joining Date</td>
			<td>${requestScope.employeeInformation.getJoinDate() }
			<input type="hidden" id="userJoiningDate" name="userJoiningDate"
				class="form-control input-sm chat-input" placeholder="userJoiningDate"
				value=${requestScope.employeeInformation.getJoinDate()} /></td>
		</tr>
		<tr colspan="2">
			<td><input type="submit" id="submit" class="btn btn-default"
				value="Update"></td>
		</tr>
	</table>
</form>
<span class="label label-success">${requestScope.message}</span>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>


</body>
</html>
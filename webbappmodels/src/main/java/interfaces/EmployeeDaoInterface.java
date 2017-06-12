package interfaces;

import webappmodels.Employee;

public interface EmployeeDaoInterface {
	Employee getEmployee(int empId);
	void updateEmployee(Employee employee);
	Integer getNewEmployeeID();
	void addEmployee(Employee employee);

}

package interfaces;

import webappmodels.Employee;

public interface EmployeeDaoInterface {
	public Employee getEmployee(int empId);
	public void updateEmployee(Employee employee);

}

package webappservice;

import implementations.DepartmentDao;
import implementations.EmployeeDao;
import implementations.SalariesDao;
import interfaces.SalaryDaoInterface;
import webappmodels.Employee;
import webappmodels.Salaries;

public class EmployeeServices {

	private DepartmentDao departmentDao = new DepartmentDao();
	private EmployeeDao employeeDao = new EmployeeDao();
	private SalariesDao salariesDao = new SalariesDao();

	public EmployeeInformations getEmployeeInformation(int empID) {

		EmployeeInformations employeeInformations = new EmployeeInformations();
		employeeInformations.setFirstName(employeeDao.getEmployee(empID).getFirstName());
		;
		employeeInformations.setLastName(employeeDao.getEmployee(empID).getLastName());
		employeeInformations.setEmpNo(employeeDao.getEmployee(empID).getEmployeeNo());
		employeeInformations.setJoinDate(employeeDao.getEmployee(empID).getHireDate());
		employeeInformations.setDeptartmentName(departmentDao.getDepartment(empID).getDepName());
		employeeInformations.setSalary(salariesDao.getSalaries(empID).getSalary());
		return employeeInformations;
	}

	public void updateEmployee(EmployeeInformations employeeInformations) {

		// TODO Auto-generated method stub

		Employee employee = employeeDao.getEmployee(employeeInformations.getEmpNo());
		Salaries salaries = salariesDao.getSalaries(employeeInformations.getEmpNo());
		employee.setFirstName(employeeInformations.getFirstName());
		employee.setLastName(employeeInformations.getLastName());
		employeeDao.updateEmployee(employee);
		salaries.setSalary(employeeInformations.getSalary());
		salariesDao.updateSalary(salaries);
	}

}

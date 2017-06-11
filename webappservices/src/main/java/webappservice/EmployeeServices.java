package webappservice;

import implementations.DepartmentDao;
import implementations.EmployeeDao;
import implementations.SalariesDao;

public class EmployeeServices {

	private DepartmentDao departmentDao = new DepartmentDao();
	private EmployeeDao employeeDao = new EmployeeDao();
	private SalariesDao salariesDao = new SalariesDao();

	public EmployeeInformations getEmployeeInformation(int empID)
	{
		
		EmployeeInformations employeeInformations= new EmployeeInformations();
		employeeInformations.setEmpName(employeeDao.getEmployee(empID).getFirstName()+" "+employeeDao.getEmployee(empID).getLastName());
		employeeInformations.setEmpNo(employeeDao.getEmployee(empID).getEmployeeNo());
		employeeInformations.setJoinDate(employeeDao.getEmployee(empID).getHireDate());
		employeeInformations.setDeptartmentName(departmentDao.getDepartment(empID).getDepName());
		employeeInformations.setSalary(salariesDao.getSalaries(empID).getSalary());
		return employeeInformations;
	}
}

package interfaces;

import webappmodels.Salaries;

public interface SalaryDaoInterface {
	public Salaries getSalaries(int empId);
	public  void updateSalary(Salaries salaries);
}

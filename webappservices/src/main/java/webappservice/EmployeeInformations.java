package webappservice;

import java.sql.Date;

public class EmployeeInformations {

      private int empNo; 
      private String empName;
      private Date joinDate;
      private String deptartmentName;
      private int salary;
      public double calculateGrossSalary() // (basic salary + 30% basic salary)
      {
    	  return this.salary+0.3*this.salary;
      }
	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
	/**
	 * @return the empNo
	 */
	public int getEmpNo() {
		return empNo;
	}
	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * @return the joinDate
	 */
	public Date getJoinDate() {
		return joinDate;
	}
	/**
	 * @param joinDate the joinDate to set
	 */
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	/**
	 * @return the deptartmentName
	 */
	public String getDeptartmentName() {
		return deptartmentName;
	}
	/**
	 * @param deptartmentName the deptartmentName to set
	 */
	public void setDeptartmentName(String deptartmentName) {
		this.deptartmentName = deptartmentName;
	}
	
}

package implementations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.omg.CORBA.Request;

import interfaces.EmployeeDaoInterface;
import webappmodels.Employee;

public class EmployeeDao implements EmployeeDaoInterface {
	@Override
	public Employee getEmployee(int empId) {
		/*
		 * String url =
		 * "jdbc:mysql://localhost:3306/employees?autoReconnect=true&useSSL=false";
		 * String user = "root"; String password = "Ajke4dikekeun@i";
		 * 
		 * try { Class.forName("com.mysql.jdbc.Driver"); } catch
		 * (ClassNotFoundException e) { e.printStackTrace(); }
		 */
		try (Connection connection = JdbcConnectionFactory.getConnection();) {
			String SQL = "Select * from EMPLOYEES WHERE emp_no=?";
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, empId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmployeeNo(resultSet.getInt("emp_no"));
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setBirthDate(resultSet.getDate("birth_date"));
				employee.setHireDate(resultSet.getDate("hire_date"));
				employee.setGender(resultSet.getString("gender"));
				return employee;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateEmployee(Employee employee) {

		// TODO Auto-generated method stub
		try (Connection connection = JdbcConnectionFactory.getConnection();) {
			String SQL = "UPDATE employees SET first_name=?, last_name=? where emp_no=?";
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setInt(3, employee.getEmployeeNo());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Integer getNewEmployeeID() {
		// TODO Auto-generated method stub
		try (Connection connection = JdbcConnectionFactory.getConnection()) {
			String SQL = "SELECT MAX(emp_no) FROM employees";
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				return (Integer) resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		try (Connection connection = JdbcConnectionFactory.getConnection()) {
			String SQL = "INSERT INTO EMPLOYEES (emp_no, birth_date, first_name,last_name,gender,hire_date) VALUES (?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, employee.getEmployeeNo());
			preparedStatement.setDate(2, employee.getBirthDate());
			preparedStatement.setString(3, employee.getFirstName());
			preparedStatement.setString(4, employee.getLastName());
			preparedStatement.setString(5, employee.getGender());
			preparedStatement.setDate(6, employee.getHireDate());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

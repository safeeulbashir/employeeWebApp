package implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import webappmodels.Salaries;

public class SalariesDao {
	public Salaries getSalaries(int empId)
	{
		try(Connection connection= JdbcConnectionFactory.getConnection();)
		{
			String SQL="Select * from SALARIES WHERE emp_no=? ORDER BY from_date, to_date DESC";
			PreparedStatement preparedStatement= connection.prepareStatement(SQL);
			preparedStatement.setInt(1, empId);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				Salaries salaries= new Salaries();
				salaries.setEmployeeNo(resultSet.getInt("emp_no"));
				salaries.setSalary(resultSet.getInt("salary"));
				salaries.setFromDate(resultSet.getDate("from_date"));
				salaries.setToDate(resultSet.getDate("to_date"));
				return salaries;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

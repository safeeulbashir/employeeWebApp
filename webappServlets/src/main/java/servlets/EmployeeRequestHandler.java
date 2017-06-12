package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webappmodels.Employee;
import webappmodels.Product;
import webappservice.EmployeeInformations;
import webappservice.EmployeeServices;

/**
 * Servlet implementation class EmployeeRequestHandler
 */
public class EmployeeRequestHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeRequestHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("function").equals("display"))
		{
			Integer employeeID=Integer.parseInt(request.getParameter("userID"));
			EmployeeServices employeeServices=new EmployeeServices();
			EmployeeInformations employeeInformations= employeeServices.getEmployeeInformation(employeeID);
			request.setAttribute("employeeInformation", employeeInformations);
			//request.setAttribute("message", employeeInformations.getEmpName());
			request.setAttribute("product", new Product("101", "Computer", 1000));
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/view.jsp");
			requestDispatcher.forward(request, response);
			
		}
		else if(request.getParameter("function").equals("displayForUpdate"))
		{
			Integer employeeID=Integer.parseInt(request.getParameter("userID"));
			EmployeeServices employeeServices=new EmployeeServices();
			EmployeeInformations employeeInformations= employeeServices.getEmployeeInformation(employeeID);
			request.setAttribute("employeeInformation", employeeInformations);
			request.setAttribute("message", "Message from Heaven");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/update.jsp");
			requestDispatcher.forward(request, response);
		}
		else if(request.getParameter("function").equals("updateRequest"))
		{
			EmployeeInformations employeeInformations= new EmployeeInformations();
			employeeInformations.setEmpNo(Integer.parseInt((String)request.getParameter("userUpdateID")));
			employeeInformations.setFirstName((String)request.getParameter("userFirstName"));
			employeeInformations.setLastName((String)request.getParameter("userLastName"));
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			String joiningDate=(String) request.getParameter("userJoiningDate");
			java.util.Date date = new java.util.Date();
			try {
				date = sdf1.parse(joiningDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
			employeeInformations.setJoinDate(sqlStartDate);
			employeeInformations.setSalary(Integer.parseInt((String)request.getParameter("userSalary")));
			EmployeeServices employeeServices= new EmployeeServices();
			employeeServices.updateEmployee(employeeInformations);
			request.setAttribute("message", "Update Successfull");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/update.jsp");
			requestDispatcher.forward(request, response);

		}
		else if(request.getParameter("function").equals("generateEmployeeID"))
		{
			EmployeeServices employeeServices=new EmployeeServices();
			Integer emplyeeID= employeeServices.getNewEmployeeID()+1;
			request.setAttribute("employeeId", emplyeeID);
			//request.setAttribute("message", "Message from Heaven");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/addEmployee.jsp");
			requestDispatcher.forward(request, response);

		}
		else if(request.getParameter("function").equals("addRequest"))
		{
			Employee employee= new Employee();
			employee.setEmployeeNo(Integer.parseInt((String)request.getParameter("userUpdateID")));
			employee.setFirstName((String)request.getParameter("userFirstName"));
			employee.setLastName((String)request.getParameter("userLastName"));
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			String dateOfBirth=(String) request.getParameter("dateOfBirth");
			java.util.Date date = new java.util.Date();
			try {
				date = sdf1.parse(dateOfBirth);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sqlDOB = new java.sql.Date(date.getTime());
			employee.setBirthDate(sqlDOB);
			employee.setGender((String)request.getParameter("gender"));
			String hireDate=(String) request.getParameter("hireDate");
			date = new java.util.Date();
			try {
				date = sdf1.parse(hireDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sqlJDate = new java.sql.Date(date.getTime());
			employee.setHireDate(sqlJDate);
			EmployeeServices employeeServices= new EmployeeServices();
			employeeServices.addEmployee(employee);
			request.setAttribute("message", "Employee Added Successfully");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/addEmployee.jsp");
			requestDispatcher.forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			}

}

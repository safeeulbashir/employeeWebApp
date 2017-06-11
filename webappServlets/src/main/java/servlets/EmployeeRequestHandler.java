package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			request.setAttribute("message", employeeInformations.getEmpName());
			request.setAttribute("product", new Product("101", "Computer", 1000));
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/view.jsp");
			requestDispatcher.forward(request, response);
			
		}
		else if(request.getParameter("function").equals("update"))
		{
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

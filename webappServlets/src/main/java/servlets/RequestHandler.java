package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestHandler
 */
public class RequestHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		String requestType = request.getParameter("requestAction");
		if (requestType.equals("VIEW_EMPLOYEE")) {
			RequestDispatcher employeeDisp = request.getRequestDispatcher("pages/view.jsp");
			employeeDisp.forward(request, response);
		} else if (requestType.equals("UPDATE_EMPLOYEE")) {
			RequestDispatcher employeeDisp = request.getRequestDispatcher("pages/update.jsp");
			employeeDisp.forward(request, response);
		}
		else if (requestType.equals("GENERATE_EMPLOYEE")) {
			RequestDispatcher employeeDisp = request.getRequestDispatcher("pages/addEmployee.jsp");
			employeeDisp.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

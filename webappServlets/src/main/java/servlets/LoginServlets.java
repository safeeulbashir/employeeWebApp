package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import trng.imcs.utl.HttpRequestConstants;
import webappmodels.UserInfo;
import webappservice.UserService;
import webappservice.UserServiceImpl;

/**
 * Servlet implementation class LoginServlets
 */
public class LoginServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String userName = request.getParameter(HttpRequestConstants.USER_NAME);
		String password = request.getParameter(HttpRequestConstants.PASSWORD);
		
		UserInfo user = new UserInfo();
		user.setLoginTime(new Date());
		user.setUserId(userName);
		user.setPassword(password);
		
		UserService userHelper = new UserServiceImpl();
		boolean validUser = userHelper.validateUser(user, getServletConfig());
		/*RequestDispatcher homeDisp1 = request.getRequestDispatcher("pages/home.jsp");
		homeDisp1.forward(request, response);
		*/if (validUser) {
			HttpSession session = request.getSession(true);
			session.setAttribute("userInfo", user);
			
			RequestDispatcher homeDisp = request.getRequestDispatcher("pages/index.jsp");
			homeDisp.forward(request, response);
		} else {
			request.setAttribute("message", "Invalid User");
			RequestDispatcher loginDisp = request.getRequestDispatcher("login");
			loginDisp.forward(request, response);
		}

	}

}

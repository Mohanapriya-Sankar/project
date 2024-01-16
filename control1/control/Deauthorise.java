package edu.training.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.service.UserAccessService;

/**
 * Servlet implementation class Deauthorise
 */
@WebServlet("/Deauthorise")
public class Deauthorise extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		UserAccessService us=new UserAccessService();
		String Name=request.getParameter("name");
		us.Deauthorize(Name);
		response.setContentType("text/html");
		response.getWriter().println("<center><h4 style=\"color:Red;\">User Deauthorised</h4></center>");
//		RequestDispatcher rd=request.getRequestDispatcher("UserControl");
//		rd.include(request, response);
	}

}

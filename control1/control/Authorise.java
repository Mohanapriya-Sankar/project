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
 * Servlet implementation class Authorise
 */
@WebServlet("/Authorise")
public class Authorise extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		UserAccessService us=new UserAccessService();
		String Name=request.getParameter("name");
		us.Authorize(Name);
		response.setContentType("text/html");
		response.getWriter().println("<center><h4 style=\"color:Green;\">User Authorised</h4></center>");
		
	}

}

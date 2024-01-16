package edu.training.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomepageControl
 */
@WebServlet("/HomepageControl")
public class HomepageControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.getParameter("index").equals ("Login"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		else if(request.getParameter("index").equals("Register"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
			rd.forward(request, response);
		}
		else
		{
			WishControl.list.clear();
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		}
		
	}

}

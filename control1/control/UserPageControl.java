package edu.training.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserPageControl
 */
@WebServlet("/UserPageControl")
public class UserPageControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.getParameter("name").equals("View Product"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("ViewProductControl");
			rd.forward(request, response);
		}
		else if(request.getParameter("name").equals("Search Product"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("Search.jsp");
			rd.forward(request, response);
		}
		else if(request.getParameter("name").equals("Log Out"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		else if(request.getParameter("name").equals("My Cart"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("ViewProductControlin");
			rd.forward(request, response);
		}
		else if(request.getParameter("name").equals("Wish List"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("WishControl");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("User.jsp");
			rd.forward(request, response);
		}
		
	}

}

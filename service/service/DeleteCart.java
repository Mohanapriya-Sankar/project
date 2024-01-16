package edu.training.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.dao.database;

/**
 * Servlet implementation class DeleteCart
 */
@WebServlet("/DeleteCart")
public class DeleteCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection con=database.connect();
		try {
			PreparedStatement ps=con.prepareStatement("Delete from cart where name=?");
			ps.setString(1,request.getParameter("name"));
			int temp=ps.executeUpdate();
			if(temp>0)
			{
				response.setContentType("text/html");
				response.getWriter().println("<h3 style'color:Green;'>Removed from cart</h3>");
				RequestDispatcher rd=request.getRequestDispatcher("User.jsp");
				rd.include(request, response);
			}
			else
			{
				response.setContentType("text/html");
				response.getWriter().println("<h3 style'color:Red;'>Request Failed</h3>");
				RequestDispatcher rd=request.getRequestDispatcher("User.jsp");
				rd.include(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

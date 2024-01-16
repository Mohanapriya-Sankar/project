package edu.training.service;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.training.dao.database;

/**
 * Servlet implementation class UsercheckService
 */
@WebServlet("/UsercheckService")
public class UsercheckService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection con=database.connect();
		response.setContentType("text/html");
		try {
			PreparedStatement ps1=con.prepareStatement("select * from userdata where Email=? and Password=?");
			ps1.setString(1,request.getParameter("id"));
			ps1.setString(2,request.getParameter("pass"));
			ResultSet rs1 =ps1.executeQuery();
			PreparedStatement ps=con.prepareStatement("select * from useraccess where Email=? and Password=?");
			ps.setString(1,request.getParameter("id"));
			ps.setString(2,request.getParameter("pass"));
			ResultSet rs =ps.executeQuery();
//			response.setContentType("text/html");
			
			if(rs.next()) 
			{
				RequestDispatcher rd=request.getRequestDispatcher("User.jsp");
				rd.forward(request, response);
				HttpSession session=request.getSession();
				session.setAttribute("unique",request.getParameter("id"));
			}
			else if(rs1.next() & !rs.next())
			{
				
//				response.getWriter().println("<center><h2 style=\"color:Red;\"></h2></center>");
				request.setAttribute("msg", "UnAuthorised User");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			else
			{
//				response.getWriter().println("<center><h3 style=\"color:Red;\">No User Found</h3></center>");
				request.setAttribute("msg", "No User Found");
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}

}

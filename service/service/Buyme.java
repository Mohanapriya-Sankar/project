package edu.training.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.dao.database;

/**
 * Servlet implementation class Buyme
 */
@WebServlet("/Buyme")
public class Buyme extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection con=database.connect();
		//String nam=request.getParameter("name");
		AddProduct ap=new AddProduct();
			PreparedStatement ps;
			try {
				ps = con.prepareStatement("select * from ECommerce where Name=?");
				ps.setString(1,request.getParameter("name"));
				ResultSet rs=ps.executeQuery();				
				while(rs.next())
				{
					int qua=rs.getInt(5);
					//response.getWriter().println(qua);
					if(qua>0)
					{
						int num=(qua-1);
						PreparedStatement ps1=con.prepareStatement("Update ECommerce set Quantity=? where Name=?");
						ps1.setInt(1, num);
						ps1.setString(2,request.getParameter("name"));
						ps1.executeUpdate();
						response.setContentType("text/html");
						response.getWriter().println("<center><h1 style=\"color:Green;\">Your Order is placed Successfully</h1></center>");
			
					}
					else
					{
						response.setContentType("text/html");
						response.getWriter().println("<center><h1 style=\"color:Red;\">Product Not Available</h1></center>");
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

}

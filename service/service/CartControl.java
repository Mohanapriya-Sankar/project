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
 * Servlet implementation class CartControl
 */
@WebServlet("/CartControl")
public class CartControl extends HttpServlet {
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
		try {
			PreparedStatement ps=con.prepareStatement("select * from ECommerce where Name=?");
			ps.setString(1,request.getParameter("name"));
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				PreparedStatement ps1=con.prepareStatement("select * from cart where name=?");
				ps1.setString(1, request.getParameter("name"));
				ResultSet rs1=ps1.executeQuery();
				HttpSession session=request.getSession();
				
				if(!rs1.next())
				{
					PreparedStatement ps2=con.prepareStatement("Insert into cart values(?,?,?,?,?)");
					ps2.setString(1, request.getParameter("name"));
					ps2.setString(2,rs.getString(3));
					ps2.setDouble(3,rs.getDouble(4));
					ps2.setInt(4, 1);
					ps2.setString(5,(String) session.getAttribute("unique"));
					ps2.executeUpdate();
					response.setContentType("text/html");
					response.getWriter().println("<center><h3 style='color:Green;'>Product Moved to Cart</h3></center>");
					RequestDispatcher rd=request.getRequestDispatcher("User.jsp");
					rd.include(request, response);
				}
				else
				{
					int quan=rs1.getInt(4);
					int num=quan+1;
					PreparedStatement ps3=con.prepareStatement("Update cart set Quantity=? where name=?");
					ps3.setInt(1,num);
					ps3.setString(2,request.getParameter("name"));
					ps3.executeUpdate();
					response.setContentType("text/html");
					response.getWriter().println("<center><h3 style='color:Green;'>Added extra count to Existing Product</h3></center>");
					RequestDispatcher rd1=request.getRequestDispatcher("User.jsp");
					rd1.include(request, response);
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

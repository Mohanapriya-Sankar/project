package edu.training.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.dao.Pojo_main;
import edu.training.dao.database;
import edu.training.service.AddProduct;

/**
 * Servlet implementation class SpecificProduct
 */
@WebServlet("/SpecificProduct")
public class SpecificProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
			List<Pojo_main>list=new ArrayList<Pojo_main>();
			while (rs.next())
			{
				list.add(new Pojo_main(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5)));
			}
			request.setAttribute("Plist",list);
			RequestDispatcher rd=request.getRequestDispatcher("SpecificProduct.jsp");
			rd.include(request, response);
			
		   }
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

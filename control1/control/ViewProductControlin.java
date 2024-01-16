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
import javax.servlet.http.HttpSession;

import edu.training.dao.Pojo_main;
import edu.training.dao.cart;
import edu.training.dao.database;
import edu.training.service.AddProduct;

/**
 * Servlet implementation class ViewProductControlin
 */
@WebServlet("/ViewProductControlin")
public class ViewProductControlin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		AddProduct ad=new AddProduct();
		Connection con=database.connect();
		try {
			List<cart>list=new ArrayList<cart>();
			PreparedStatement ps=con.prepareStatement("select * from cart where user=?");
			HttpSession session=request.getSession();
			ps.setString(1,(String) session.getAttribute("unique"));
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{
				list.add(new cart(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4)));
			}
			request.setAttribute("Plist",list);
			RequestDispatcher rd=request.getRequestDispatcher("ProductDetails.jsp");
			rd.forward(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

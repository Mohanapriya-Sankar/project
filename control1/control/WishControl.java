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

/**
 * Servlet implementation class WishControl
 */
@WebServlet("/WishControl")
public class WishControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public static List<Pojo_main>list=new ArrayList<Pojo_main>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		public static List<Pojo_main>list=new ArrayList<Pojo_main>();
		String Name=request.getParameter("name");
		Connection con=database.connect();
		try {
			PreparedStatement ps=con.prepareStatement("select * from ECommerce where Name=?");
			ps.setString(1, Name);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				list.add(new Pojo_main(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5)));
			}
			
			request.setAttribute("Wlist",list);
			RequestDispatcher rd=request.getRequestDispatcher("WishList.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

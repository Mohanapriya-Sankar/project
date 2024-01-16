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

import edu.training.dao.User;
import edu.training.dao.database;

/**
 * Servlet implementation class UserControl
 */
@WebServlet("/UserControl")
public class UserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=database.connect();
		List<User>list=new ArrayList<User>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from userdata");
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{
				list.add(new User(rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
			request.setAttribute("Ulist",list);
			RequestDispatcher rd=request.getRequestDispatcher("useraccess.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

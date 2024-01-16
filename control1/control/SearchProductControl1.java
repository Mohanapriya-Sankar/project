package edu.training.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.dao.Pojo_main;
import edu.training.dao.database;

/**
 * Servlet implementation class SearchProductControl1
 */
@WebServlet("/SearchProductControl1")
public class SearchProductControl1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=database.connect();
		List<Pojo_main>list=new ArrayList<Pojo_main>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from ECommerce where Description like ?");
			ps.setString(1,"%"+request.getParameter("search")+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				list.add(new Pojo_main(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5)));
			}
			request.setAttribute("plist",list);
			request.getRequestDispatcher("ResultSearch.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

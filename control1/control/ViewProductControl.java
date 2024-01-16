package edu.training.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.dao.Pojo_main;
import edu.training.service.AddProduct;

/**
 * Servlet implementation class ViewProductControl
 */
@WebServlet("/ViewProductControl")
public class ViewProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			AddProduct ad=new AddProduct();
			try {
				List<Pojo_main>list=ad.viewProduct();
				request.setAttribute("Plist",list);
				RequestDispatcher rd=request.getRequestDispatcher("ViewProduct.jsp");
				rd.forward(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}

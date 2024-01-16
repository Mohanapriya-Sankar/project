package edu.training.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.service.AddProduct;

/**
 * Servlet implementation class deleteControl
 */
@WebServlet("/deleteControl")
public class deleteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id=Integer.parseInt(request.getParameter("id"));
		AddProduct d=new AddProduct();
		d.deleteProduct(id);
		response.setContentType("text/html");
		response.getWriter().println("<h3 style=\"color:Red;\">Product Deleted</h3>");
		RequestDispatcher rd=request.getRequestDispatcher("ViewContol");
		rd.include(request, response);
	}

}

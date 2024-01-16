package edu.training.control;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.dao.Pojo_main;
import edu.training.service.AddProduct;

/**
 * Servlet implementation class RegisterationController
 */
@WebServlet("/RegisterationController")
public class RegisterationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id=Integer.parseInt(request.getParameter("Id"));
		String name=request.getParameter("Name");
		String desc=request.getParameter("Description");
		double price=Double.parseDouble(request.getParameter("Price"));
		int qty=Integer.parseInt(request.getParameter("Quantity"));
		AddProduct ad=new AddProduct();
		Pojo_main pm=new Pojo_main(id,name,desc,price,qty);
		try{
			ad.addProduct(pm);
			response.setContentType("text/html");
			response.getWriter().println("<center><h2 style=\"color:Green;\">Product Updated Successfully</h2></center>");
			request.getRequestDispatcher("AddService.jsp").include(request,response);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}

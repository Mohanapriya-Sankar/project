package edu.training.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.dao.Pojo_main;
import edu.training.service.AddProduct;

/**
 * Servlet implementation class ViewContol
 */
@WebServlet("/ViewContol")
public class ViewContol extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AddProduct ap=new AddProduct();
		try
		{
			List<Pojo_main>list=ap.viewProduct();
			request.setAttribute("pList",list);
			request.getRequestDispatcher("ViewService.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}

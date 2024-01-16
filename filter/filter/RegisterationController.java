package edu.training.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import edu.training.dao.Pojo_main;

/**
 * Servlet Filter implementation class AddProduct
 */
@WebFilter("/RegisterationController")
public class RegisterationController extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		int id=Integer.parseInt(request.getParameter("Id"));
		String name=request.getParameter("Name");
		String desc=request.getParameter("Description");
		Double pri=Double.parseDouble(request.getParameter("Price"));
		int num=Integer.parseInt(request.getParameter("Quantity"));
		if((pri >0 && num>0) &&name.length()>3)
		{
			Pojo_main p=new Pojo_main(id,name,desc,pri,num);
			request.setAttribute("obj",p);
			chain.doFilter(request, response);	
		}
		else
		{
			response.setContentType("text/html");
			response.getWriter().println("<center><h4 style=\"color:Red;\">Invalid Price and Quantity</h4></center>");
			RequestDispatcher rd=request.getRequestDispatcher("AddService.jsp");
			rd.include(request, response);
		}
		
	}
}

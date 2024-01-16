package edu.training.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class RegisterUserControl
 */
@WebFilter("/RegisterUserControl")
public class RegisterUserControl extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String name=request.getParameter("name");
		String dob=request.getParameter("dob");
		String year[]=dob.split("-");
		String year1=year[0];
		int y=Integer.parseInt(year1);
		String pas=request.getParameter("pass");
		String mail=request.getParameter("email");
		String num=request.getParameter("num");
		
	if(name.length()>3&Pattern.matches("^[a-zA-Z0-9]{8,15}$",pas)
			&Pattern.matches("^[6-9]{1}+[0-9]{9}$",num)
			&Pattern.matches("^[a-z]([A-Za-z0-9_.])+@[a-z]+\\.(com||in||org)$",mail)
			&y<2000)
	{
		chain.doFilter(request, response);
	}
	else
	{
		if(request.getParameter("name").length()<3)
		{
			response.getWriter().println("<center><h4 style=\"color:Red;\">Name should have more than 3 letters</h4></center>");
		}
		if(!Pattern.matches("^[a-zA-Z0-9]{8,15}$",pas))
				{
			response.getWriter().println("<center><h4 style='color:red'>Password should be minimum 8 and upto 15 and should contain alphanumeric characters only</h4></center>");
				}
		if(!Pattern.matches("^[6-9]{1}+[0-9]{9}$",num))
		{
			response.getWriter().println("<center><h4 style='color:red'>Phone number should start in 6 or 7 or 8 or 9 and contain 10 numbers</h4></center>");
		}
		if(!Pattern.matches("^[a-z]([A-Za-z0-9_.])+@[a-z]+\\.(com|in|org)$", mail))
        {
            response.getWriter().println("<center><h4 style='color:red'>Email-id should be end with org or in or com and start with lowercase</h4></center>");    
        }
        if(y>2000)
        {
            response.getWriter().println("<center><h4 style='color:red'>DOB should be before 2000</h4></center>");        
        }
        
        response.setContentType("text/html");
        RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
        rd.include(request, response);
	}
	}
}

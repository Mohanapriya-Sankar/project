package edu.training.control;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.dao.User;
import edu.training.service.UserPageService;

/**
 * Servlet implementation class RegisterUserControl
 */
@WebServlet("/RegisterUserControl")
public class RegisterUserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String name=request.getParameter("name");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//Date dob=new SimpleDateFormat("dd/MM/yyyy").parse(dat);  
		String dat=(String)request.getParameter("dob");
		Date dob=null;
		try {
			dob = sdf.parse(dat);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String dob=request.getParameter("DOB");
		String no=request.getParameter("num");
		String mail=request.getParameter("email");
		String pass=request.getParameter("pass");
		User details=new User(name, dob, no, mail, pass);
		UserPageService ad=new UserPageService();
		
		try
		{
			ad.addUser(details);
			response.setContentType("text/html");
			response.getWriter().println("<h3 style=\"color:Green;\">Student Details Updated Successfully</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.forward(request,response);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}

package edu.training.dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class database
{
	public static Connection connect()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt","root","root");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
		
	}

}

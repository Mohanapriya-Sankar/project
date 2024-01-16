package edu.training.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.training.dao.Pojo_main;
import edu.training.dao.User;
import edu.training.dao.database;

public class UserAccessService {
	Connection con=database.connect();
	public String Authorize(String Name)
	{
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from userdata where Name=?");
			ps.setString(1, Name);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				PreparedStatement ps1=con.prepareStatement("Insert into useraccess values(?,?,?)");
				ps1.setString(1,rs.getString(1));
				ps1.setString(2,rs.getString(4));
				ps1.setString(3,rs.getString(5));
				ps1.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "User Authorised";
		
	}
	public String Deauthorize(String Name)
	{
		PreparedStatement ps1;
		try {
			ps1 = con.prepareStatement("Delete from useraccess where Name=?");
			ps1.setString(1,Name);
			ps1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "User Deauthorised";
		
	}
	public String Deleteuser(String Name)
	{
		UserAccessService us=new UserAccessService();
		us.Deauthorize(Name);
		PreparedStatement ps2;
		try {
			ps2 = con.prepareStatement("Delete from userdata where Name=?");
			ps2.setString(1, Name);
			ps2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "User Deleted";
		
	}

}

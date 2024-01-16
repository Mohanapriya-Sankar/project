package edu.training.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import edu.training.dao.User;
import edu.training.dao.database;

public class UserPageService {
	public String addUser(User det) throws SQLException
	{
		Connection con=database.connect();
		PreparedStatement ps=con.prepareStatement("Insert into userdata values(?,?,?,?,?)");
		ps.setString(1,det.getName());
		ps.setObject(2,(Date)det.getDOB());
		ps.setString(3,det.getPhone_Number());
		ps.setString(4,det.getEmail());
		ps.setString(5,det.getPassword());
		ps.executeUpdate();
		
		return "User Created" ;	
	}

}

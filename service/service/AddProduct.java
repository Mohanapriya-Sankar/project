package edu.training.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.training.dao.Pojo_main;
import edu.training.dao.database;

public class AddProduct {
	public String addProduct(Pojo_main attr) throws SQLException
	{
		Connection con=database.connect();
		PreparedStatement ps=con.prepareStatement("Insert into ECommerce values(?,?,?,?,?)");
		ps.setInt(1,attr.getId());
		ps.setString(2,attr.getName());
		ps.setString(3,attr.getDescription());
		ps.setDouble(4,attr.getPrice());
		ps.setInt(5,attr.getQuantity());
		ps.executeUpdate();
		return "Product Created";
		
	}
	

	public List<Pojo_main>viewProduct() throws SQLException
	{
		List<Pojo_main>list=new ArrayList<Pojo_main>();
		Connection con=database.connect();
		PreparedStatement ps=con.prepareStatement("select * from ECommerce");
		ResultSet rs=ps.executeQuery();
		while (rs.next())
		{
			list.add(new Pojo_main(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5)));
		}
		return list;
	}
	
	public void deleteProduct(int id)
	{
		Connection con=database.connect();
		PreparedStatement p;
		try {
			p = con.prepareStatement("Delete from ECommerce where Id=?");
			p.setInt(1,id);
			p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateProduct(int id, double price,int quan)
	{
		Connection con=database.connect();
		try {
			PreparedStatement ps=con.prepareStatement("Update ECommerce set Price=?,Quantity=? where Id=?");
			ps.setDouble(1,price);
			ps.setInt(2,quan);
			ps.setInt(3, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
	

package edu.training.dao;
import java.util.Date;

public class User {
	private String Name;
	private Date DOB;
	private String Phone_Number;
	private String Email;
	private String Password;
	public User(String name, Date dob , String ph_no, String email, String password) {
		super();
		Name = name;
		DOB = dob;
		Phone_Number = ph_no;
		Email = email;
		Password = password;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getPhone_Number() {
		return Phone_Number;
	}
	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "User [Name=" + Name + ", Date=" + DOB + ", ph_no=" + Phone_Number + ", Email=" + Email + ", Password="
				+ Password + "]";
	}
	
	

}

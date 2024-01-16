package edu.training.dao;

public class cart {
	private String Name;
	private String Description;
	private double Price;
	private int Quantity;
	public cart(String name, String description, double price, int quantity) {
		super();
		Name = name;
		Description = description;
		Price = price;
		Quantity = quantity;
	}
	@Override
	public String toString() {
		return "cart [Name=" + Name + ", Description=" + Description + ", Price=" + Price + ", Quantity=" + Quantity
				+ "]";
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	

}

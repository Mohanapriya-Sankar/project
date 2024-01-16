package edu.training.dao;

public class Pojo_main {
	private int Id;
	private String Name;
	private String Description;
	private Double Price;
	private int Quantity;
	public Pojo_main(int id, String name, String description, Double price, int quantity) {
		super();
		Id = id;
		Name = name;
		Description = description;
		Price = price;
		Quantity = quantity;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	@Override
	public String toString() {
		return "Pojo_main [Id=" + Id + ", Name=" + Name + ", Description=" + Description + ", Price=" + Price
				+ ", Quantity=" + Quantity + "]";
	}
	
}
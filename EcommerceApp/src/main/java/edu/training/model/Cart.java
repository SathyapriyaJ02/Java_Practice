package edu.training.model;

public class Cart 
{
	String userName;
	int product_id;
	String product_name;
	String product_desc;
	int product_price;
	int quantity;
	
	
	
	
	public Cart(int product_id, String product_name, String product_desc, int product_price) {
		super();
		this.userName = userName;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_desc = product_desc;
		this.product_price = product_price;
		
	}
	
	public Cart(String userName, int product_id, String product_name, String product_desc, int product_price,
			int quantity) {
		super();
		this.userName = userName;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_desc = product_desc;
		this.product_price = product_price;
		this.quantity = quantity;
	}
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [userName=" + userName + ", product_id=" + product_id + ", product_name=" + product_name
				+ ", product_desc=" + product_desc + ", product_price=" + product_price +"]";
	}
	
	
	
	
	
	
	
}

package com.rock.ShoppingApplication.Model;

public class ProductDto {
	
	private String name;
	private String quantity;
	private String actualprice;
	private String discountedprice;
	private String discountPercentage;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getActualprice() {
		return actualprice;
	}
	public void setActualprice(String actualprice) {
		this.actualprice = actualprice;
	}
	public String getDiscountedprice() {
		return discountedprice;
	}
	public void setDiscountedprice(String discountedprice) {
		this.discountedprice = discountedprice;
	}
	public String getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(String discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
	

}

package com.test.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MKB_STORE")
public class Product {

	@javax.persistence.Id
	private int Id;
	private String productName;
	private String quantity;
	private String gst;
	private Double price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String productName, String quantity, String gst, Double price) {
		super();
		Id = id;
		this.productName = productName;
		this.quantity = quantity;
		this.gst = gst;
		this.price = price;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
		
}
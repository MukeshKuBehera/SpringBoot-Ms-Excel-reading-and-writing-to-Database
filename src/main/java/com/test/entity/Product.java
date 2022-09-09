package com.test.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MKB_STORE")
public class Product {

	@javax.persistence.Id
	private Integer Id;
	private String productName;
	private Double quantity;
	private String gst;
	private Double price;

	public Product(Integer id, String productName, Double quantity, String gst, Double price) {
		super();
		Id = id;
		this.productName = productName;
		this.quantity = quantity;
		this.gst = gst;
		this.price = price;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
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

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [Id=" + Id + ", productName=" + productName + ", quantity=" + quantity + ", gst=" + gst
				+ ", price=" + price + "]";
	}

}
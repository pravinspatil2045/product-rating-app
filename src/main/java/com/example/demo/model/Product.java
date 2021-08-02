package com.example.demo.model;

public class Product {

	private int productId;
	private double rating;
	private int count;

	public Product() {
		super();
	}

	public Product(int productId, double rating, int count) {
		super();
		this.productId = productId;
		this.rating = rating;
		this.count = count;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}

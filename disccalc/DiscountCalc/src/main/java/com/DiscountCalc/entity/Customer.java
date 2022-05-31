package com.DiscountCalc.entity;

public class Customer {

	private String type;
	private int amount;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Customer(String type, int amount) {
		super();
		this.type = type;
		this.amount = amount;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [type=" + type + ", amount=" + amount + "]";
	}
	
	
}

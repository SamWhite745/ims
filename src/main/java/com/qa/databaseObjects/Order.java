package com.qa.databaseObjects;

import java.util.List;

public class Order {
	private int id;
	private Customer customer;
	private List<ItemOrders> itemOrders;
	
	public Order(Customer customer) {
		this.customer = customer;
	}

	public Order(int id, Customer customer, List<ItemOrders> itemOrders) {
		this.id = id;
		this.customer = customer;
		this.itemOrders = itemOrders;
	}
	
	public Order(int id, Customer cust) {
		this.id = id;
		this.customer = cust;
	}

	public int getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<ItemOrders> getItemOrders() {
		return itemOrders;
	}

	public void setItemOrders(List<ItemOrders> itemOrders) {
		this.itemOrders = itemOrders;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String toString() {
		return "Order id : " + id + " - " + customer.getName() + ", Id : " + customer.getId();
	}

	
}

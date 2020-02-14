package com.qa.databaseobjects;

import java.util.List;

/**
 * @author Sam Implementation of the order table to perform logic on.
 *
 */
public class Order {
	private int id;
	private Customer customer;
	private List<ItemOrders> itemOrders;
	
	/**
	 * @param customer
	 */
	public Order(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @param id
	 * @param customer
	 * @param itemOrders
	 */
	public Order(int id, Customer customer, List<ItemOrders> itemOrders) {
		this.id = id;
		this.customer = customer;
		this.itemOrders = itemOrders;
	}
	
	/**
	 * @param id
	 * @param cust
	 */
	public Order(int id, Customer cust) {
		this.id = id;
		this.customer = cust;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return list of itemOrders
	 */
	public List<ItemOrders> getItemOrders() {
		return itemOrders;
	}

	/**
	 * @param itemOrders
	 */
	public void setItemOrders(List<ItemOrders> itemOrders) {
		this.itemOrders = itemOrders;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/**
	 * @return order to string
	 */
	public String toString() {
		return "Order id : " + id + " - " + customer.getName() + ", Id : " + customer.getId();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + id;
		result = prime * result + ((itemOrders == null) ? 0 : itemOrders.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id != other.id)
			return false;
		if (itemOrders == null) {
			if (other.itemOrders != null)
				return false;
		} else if (!itemOrders.equals(other.itemOrders))
			return false;
		return true;
	}
	
}

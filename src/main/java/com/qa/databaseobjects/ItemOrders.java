package com.qa.databaseobjects;

public class ItemOrders {
	private int id;
	private int itemId;
	private int orderId;
	private int quantity;
	private int itemCost;
	
	/**
	 * @param id
	 * @param itemId
	 * @param orderId
	 * @param quantity
	 * @param itemCost
	 */
	public ItemOrders(int id, int itemId, int orderId, int quantity, int itemCost) {
		this.id = id;
		this.itemId = itemId;
		this.orderId = orderId;
		this.quantity = quantity;
		this.itemCost = itemCost;
	}
	
	public ItemOrders(int itemId, int orderId, int quantity, int itemCost) {
		this.itemId = itemId;
		this.orderId = orderId;
		this.quantity = quantity;
		this.itemCost = itemCost;
	}

	public int getId() {
		return id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getItemCost() {
		return itemCost;
	}

	public int getItem() {
		return itemId;
	}

	public int getOrder() {
		return orderId;
	}
	
	@Override
	public String toString() {
		return " - id: " + this.id + ", itemId: " + this.itemId + ", orderId: " + this.orderId + ", quantity: " + this.quantity + ", total cost: " + this.itemCost;
	}

}

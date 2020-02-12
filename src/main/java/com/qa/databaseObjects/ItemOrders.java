package com.qa.databaseObjects;

public class ItemOrders {
	private int id;
	private int itemId;
	private int orderId;
	private int quantity;
	private int itemCost;

	public ItemOrders(int id, int itemId, int orderId, int quantity) {
		this.id = id;
		this.itemId = itemId;
		this.orderId = orderId;
		this.quantity = quantity;
		this.itemCost = quantity * itemId;
	}
	
	public ItemOrders(int id, int itemId, int orderId, int quantity, int itemCost) {
		this.id = id;
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

}

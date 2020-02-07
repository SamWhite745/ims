package com.qa.databaseObjects;

public class ItemOrders {
	private int id;
	private Item item;
	private Order order;
	private int quantity;
	private int itemCost;

	public ItemOrders(int id, Item item, Order order, int quantity) {
		this.id = id;
		this.item = item;
		this.order = order;
		this.quantity = quantity;
		this.itemCost = quantity * item.getValue();
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

	public Item getItem() {
		return item;
	}

	public Order getOrder() {
		return order;
	}

}

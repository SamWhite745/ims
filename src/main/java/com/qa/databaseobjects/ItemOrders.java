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

	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setItem(int itemId) {
		this.itemId = itemId;
	}	
	
	public void setOrder(int orderId) {
		this.orderId = orderId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setItemCost(int itemCost) {
		this.itemCost = itemCost;
	}

	public int getId() {
		return id;
	}
	
	public int getQuantity() {
		return quantity;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + itemCost;
		result = prime * result + itemId;
		result = prime * result + orderId;
		result = prime * result + quantity;
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
		ItemOrders other = (ItemOrders) obj;
		if (id != other.id)
			return false;
		if (itemCost != other.itemCost)
			return false;
		if (itemId != other.itemId)
			return false;
		if (orderId != other.orderId)
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

}

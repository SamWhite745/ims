package com.qa.databaseobjects;

/**
 * @author Sam
 *
 */
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

	/**
	 * @param itemId
	 * @param orderId
	 * @param quantity
	 * @param itemCost
	 */
	public ItemOrders(int itemId, int orderId, int quantity, int itemCost) {
		this.itemId = itemId;
		this.orderId = orderId;
		this.quantity = quantity;
		this.itemCost = itemCost;
	}

	
	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @param itemId
	 */
	public void setItem(int itemId) {
		this.itemId = itemId;
	}	
	
	/**
	 * @param orderId
	 */
	public void setOrder(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * @param itemCost
	 */
	public void setItemCost(int itemCost) {
		this.itemCost = itemCost;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @return item cost
	 */
	public int getItemCost() {
		return itemCost;
	}

	/**
	 * @return item id
	 */
	public int getItem() {
		return itemId;
	}

	/**
	 * @return order id
	 */
	public int getOrder() {
		return orderId;
	}
	
	/**
	 * @return item order to string
	 */
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

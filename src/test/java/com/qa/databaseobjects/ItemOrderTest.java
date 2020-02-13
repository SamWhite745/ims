package com.qa.databaseobjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemOrderTest {
	
	private ItemOrders itemOrder;
	private ItemOrders other;
	
	@Before
	public void setUp() {
		itemOrder = new ItemOrders(1, 1, 1, 10, 1000);
		other = new ItemOrders(1, 1, 1, 10, 1000);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(itemOrder.getId());
		assertNotNull(itemOrder.getItem());
		assertNotNull(itemOrder.getOrder());
		assertNotNull(itemOrder.getQuantity());
		assertNotNull(itemOrder.getItemCost());
		
		
		itemOrder.setId(0);
		assertNotNull(itemOrder.getId());
		
		itemOrder.setItem(0);
		assertNotNull(itemOrder.getItem());
		
		itemOrder.setOrder(0);
		assertNotNull(itemOrder.getOrder());
		
		itemOrder.setQuantity(0);
		assertNotNull(itemOrder.getQuantity());
		
		itemOrder.setItemCost(0);
		assertNotNull(itemOrder.getItemCost());
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(itemOrder.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(itemOrder.equals(new Object()));
	}
	
	@Test
	public void createItemOrdersWithId() {
		assertEquals(1, itemOrder.getId());
		assertEquals(1, itemOrder.getItem());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(itemOrder.equals(itemOrder));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(itemOrder.equals(other));
	}
	
	@Test
	public void ItemOrdersItemIdsNotEqual() {
		other.setItem(2);
		assertFalse(itemOrder.equals(other));
	}
	
	@Test
	public void ItemOrdersIdsNotEqual() {
		other.setId(2);
		assertFalse(itemOrder.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		itemOrder.setId(0);
		other.setId(0);
		assertTrue(itemOrder.equals(other));
	}
		
	
	@Test
	public void constructorWithoutId() {
		ItemOrders customer = new ItemOrders(1, 1, 10, 1000);
		assertEquals(0, customer.getId());
		assertNotNull(customer.getItem());
		assertNotNull(customer.getOrder());
		assertNotNull(customer.getQuantity());
		assertNotNull(customer.getItemCost());

	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(itemOrder.hashCode(), other.hashCode());
	}
	
//" - id: " + this.id + ", itemId: " + this.itemId + ", orderId: " + this.orderId + ", quantity: " + this.quantity + ", total cost: " + this.itemCost;
	@Test
	public void toStringTest() {
		String toString = " - id: 1, itemId: 1, orderId: 1, quantity: 10, total cost: 1000";
		assertEquals(toString, itemOrder.toString());
	}
}

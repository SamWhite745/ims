package com.qa.databaseobjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	
	private Order order;
	private Order other;
	private ItemOrders itemOrder;
	private Customer customer;
	List<ItemOrders> itemOrders;
	
	@Before
	public void setUp() {
		customer = new Customer(1, "Sam White");
		itemOrder = new ItemOrders(1, 1, 1, 10, 1000);
		itemOrders = new ArrayList<>();
		itemOrders.add(itemOrder);
		
		order = new Order(1, customer, itemOrders);
		other = new Order(1, customer, itemOrders);
		
		
	}
	
	@Test
	public void settersTest() {
		assertNotNull(order.getId());
		assertNotNull(order.getCustomer());
		assertNotNull(order.getItemOrders());
		
		order.setId(0);
		assertNotNull(order.getId());
		
		order.setCustomer(null);
		assertNull(order.getCustomer());
		
		order.setItemOrders(null);
		assertNull(order.getItemOrders());
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}
	
	@Test
	public void createItemWithId() {
		assertEquals(1, order.getId());
		assertEquals(customer, order.getCustomer());
		assertEquals(itemOrders, order.getItemOrders());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(order.equals(order));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(order.equals(other));
	}
	
	@Test
	public void OrderCustomerNullButOtherOrderCustomerNotNull() {
		order.setCustomer(null);
		assertFalse(order.equals(other));
	}
	
	public void OrderItemsNullButOtherOrderItemsNotNull() {
		order.setItemOrders(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void OrderCustomersNotEqual() {
		other.setCustomer(new Customer(2, "Chris Perrins"));
		assertFalse(order.equals(other));
	}
	
	@Test
	public void OrderItemsNotEqual() {
		List<ItemOrders> otherItems = new ArrayList<>();
		otherItems.add(new ItemOrders(2,2,2,20,2000));
		other.setItemOrders(otherItems);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void ItemIdsNotEqual() {
		other.setId(2);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Order order = new Order(customer);
		assertEquals(0, order.getId());
		assertNotNull(order.getCustomer());
		assertNull(order.getItemOrders());

	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(order.hashCode(), other.hashCode());
	}
	
	@Test
	public void hashCodeTestWithNull() {
		Order item = new Order(0, null, null);
		Order other = new Order(0, null, null);
		assertEquals(item.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "Order id : 1 - Sam White, Id : 1";
		assertEquals(toString, order.toString());
	}
}

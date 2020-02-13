package com.qa.databaseobjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	
	private Customer customer;
	private Customer other;
	
	@Before
	public void setUp() {
		customer = new Customer(1, "Sam White");
		other = new Customer(1, "Sam White");
	}
	
	@Test
	public void settersTest() {
		assertNotNull(customer.getId());
		assertNotNull(customer.getName());
		
		customer.setId(0);
		assertNotNull(customer.getId());
		
		customer.setName(null);
		assertNull(customer.getName());
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(customer.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(customer.equals(new Object()));
	}
	
	@Test
	public void createCustomerWithId() {
		assertEquals(1, customer.getId());
		assertEquals("Sam White", customer.getName());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(customer.equals(customer));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void customerNameNullButOtherNameNotNull() {
		customer.setName(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void customerNamesNotEqual() {
		other.setName("rhys");
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		customer.setName(null);
		other.setName(null);
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void nullId() {
		customer.setId(0);
		assertFalse(customer.equals(other));
	}
	
	
	@Test
	public void otherIdDifferent() {
		other.setId(2);
		assertFalse(customer.equals(other));
	}
	
	
	@Test
	public void constructorWithoutId() {
		Customer customer = new Customer("Sam White");
		assertEquals(0, customer.getId());
		assertNotNull(customer.getName());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(customer.hashCode(), other.hashCode());
	}
	
	@Test
	public void hashCodeTestWithNull() {
		Customer customer = new Customer(0, null);
		Customer other = new Customer(0, null);
		assertEquals(customer.hashCode(), other.hashCode());
	}

	@Test
	public void toStringTest() {
		String toString = "1 Sam White";
		assertEquals(toString, customer.toString());
	}
}
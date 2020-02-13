package com.qa.databaseobjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	
	private Item item;
	private Item other;
	
	@Before
	public void setUp() {
		item = new Item(1, "Draven_Skin", 4800);
		other = new Item(1, "Draven_Skin", 4800);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(item.getId());
		assertNotNull(item.getName());
		assertNotNull(item.getValue());
		
		item.setId(0);
		assertNotNull(item.getId());
		
		item.setName(null);
		assertNull(item.getName());
		
		item.setValue(0);
		assertNotNull(item.getValue());
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}
	
	@Test
	public void createItemWithId() {
		assertEquals(1, item.getId());
		assertEquals("Draven_Skin", item.getName());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(item.equals(item));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(item.equals(other));
	}
	
	@Test
	public void ItemNameNullButOtherNameNotNull() {
		item.setName(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void ItemNamesNotEqual() {
		other.setName("Jinx_Skin");
		assertFalse(item.equals(other));
	}
	
	@Test
	public void ItemValuesNotEqual() {
		other.setValue(6300);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void ItemIdsNotEqual() {
		other.setId(2);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		item.setName(null);
		other.setName(null);
		assertTrue(item.equals(other));
	}
		
	
	@Test
	public void constructorWithoutId() {
		Item customer = new Item("Draven_Skin", 4800);
		assertEquals(0, customer.getId());
		assertNotNull(customer.getName());
		assertNotNull(customer.getValue());

	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(item.hashCode(), other.hashCode());
	}
	
	@Test
	public void hashCodeTestWithNull() {
		Item item = new Item(0, null, 0);
		Item other = new Item(0, null, 0);
		assertEquals(item.hashCode(), other.hashCode());
	}

	@Test
	public void toStringTest() {
		String toString = "1 Draven_Skin 4800";
		assertEquals(toString, item.toString());
	}
}

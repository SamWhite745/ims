package com.qa.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.databaseobjects.Item;
import com.qa.services.ItemService;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

	/**
	 * The thing I want to fake functionality for
	 */
	@Mock
	private ItemService itemService;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy
	@InjectMocks
	private ItemController itemController;

	@Test
	public void readAllTest() {
		itemController.readAll();
		Mockito.verify(itemService, Mockito.times(1)).readAll();
	}

	@Test
	public void createTest() {
		String name = "Draven_Skin";
		Mockito.doReturn(name , "1000").when(itemController).getStringInput();
		Item item = new Item(name, 1000);
		itemController.create();
		Mockito.verify(itemService, Mockito.times(1)).create(item);
	}

	@Test
	public void updateTest() {
		String name = "Sam White";
		Mockito.doReturn("1", name, "1000").when(itemController).getStringInput();

		Item item = new Item(1, name, 1000);
		itemController.update();
		Mockito.verify(itemService, Mockito.times(1)).update(item);
	}

	@Test
	public void deleteTest() {
		Mockito.doReturn("1").when(itemController).getStringInput();
		itemController.delete();
		Mockito.verify(itemService, Mockito.times(1)).delete(1);
	}

}
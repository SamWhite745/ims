package com.qa.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.databaseobjects.Customer;
import com.qa.databaseobjects.Item;
import com.qa.services.ItemService;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerIT {
	
	/**
	 *  The thing I want to fake functionality for
	 */
	@Mock
	private ItemService itemService;
	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer controller
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
		Mockito.doReturn(name).when(itemController).getStringInput();
		int value = 1000;
		Mockito.doReturn(value).when(itemController).getIntInput();
		Item item = new Item(name, value);
		itemController.create();
		Mockito.verify(itemService, Mockito.times(1)).create(item);
	}

	@Test
	public void updateTest() {
		int id = 1;
		String name = "Draven_Skin";
		int value = 1000;

		Mockito.doReturn(id, value).when(itemController).getIntInput();
		Mockito.doReturn(name).when(itemController).getStringInput();
		
		Item item = new Item(id, name, value);
		itemController.update();
		Mockito.verify(itemService, Mockito.times(1)).update(item);
	}
	
	@Test
	public void deleteTest() {
		int id = 1;
		Mockito.doReturn(id).when(itemController).getIntInput();
		itemController.delete();
		Mockito.verify(itemService, Mockito.times(1)).delete(1);
	}
	
}
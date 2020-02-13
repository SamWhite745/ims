package com.qa.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.databasemanipulation.ItemDao;
import com.qa.databaseobjects.Item;


@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {
	
	@Mock
	private ItemDao itemDao;
	
	@InjectMocks
	private ItemService itemServices;
	
	@Test
	public void itemServicesCreate() {
		Item item = new Item(1, "Draven_Skin", 4800);
		itemServices.create(item);
		Mockito.verify(itemDao, Mockito.times(1)).create(item);
	}
	
	@Test
	public void itemServicesRead() {
		itemServices.readAll();
		Mockito.verify(itemDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void itemServicesUpdate() {
		Item item = new Item(1, "Draven_Skin", 4800);
		itemServices.update(item);
		Mockito.verify(itemDao, Mockito.times(1)).update(item);
	}
	
	@Test
	public void itemServicesDelete() {
		itemServices.delete(1);;
		Mockito.verify(itemDao, Mockito.times(1)).delete(1);
	}
}
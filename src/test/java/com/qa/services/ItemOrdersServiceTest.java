package com.qa.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.databasemanipulation.ItemOrdersDao;
import com.qa.databaseobjects.ItemOrders;


@RunWith(MockitoJUnitRunner.class)
public class ItemOrdersServiceTest {
	
	@Mock
	private ItemOrdersDao itemOrdersDao;
	
	@InjectMocks
	private ItemOrdersService itemOrdersServices;
	
	@Test
	public void itemServicesCreate() {
		ItemOrders itemOrders = new ItemOrders(1, 1, 1, 10, 1000);
		itemOrdersServices.create(itemOrders);
		Mockito.verify(itemOrdersDao, Mockito.times(1)).create(itemOrders);
	}
	
	@Test
	public void itemServicesRead() {
		itemOrdersServices.readAll();
		Mockito.verify(itemOrdersDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void itemServicesUpdate() {
		ItemOrders itemOrders = new ItemOrders(1, 1, 1, 10, 1000);
		itemOrdersServices.update(itemOrders);
		Mockito.verify(itemOrdersDao, Mockito.times(1)).update(itemOrders);
	}
	
	@Test
	public void itemServicesDelete() {
		itemOrdersServices.delete(1);
		Mockito.verify(itemOrdersDao, Mockito.times(1)).delete(1);
	}
	
	@Test
	public void itemServicesDeleteByOrder() {
		itemOrdersServices.deleteByOrder(1);
		Mockito.verify(itemOrdersDao, Mockito.times(1)).deleteByOrder(1);
	}
}
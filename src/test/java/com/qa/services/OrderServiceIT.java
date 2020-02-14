package com.qa.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.databasemanipulation.OrderDao;
import com.qa.databaseobjects.Customer;
import com.qa.databaseobjects.Order;


@RunWith(MockitoJUnitRunner.class)
public class OrderServiceIT {
	
	@Mock
	private OrderDao orderDao;
	
	@InjectMocks
	private OrderService orderServices;
	
	@Test
	public void itemServicesCreate() {
		Customer customer = new Customer(1, "Sam White");
		Order order = new Order(1, customer);
		orderServices.create(order);
		Mockito.verify(orderDao, Mockito.times(1)).create(order);
	}
	
	@Test
	public void itemServicesRead() {
		orderServices.readAll();
		Mockito.verify(orderDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void itemServicesUpdate() {
		Customer customer = new Customer(1, "Sam White");
		Order order = new Order(1, customer);
		orderServices.update(order);
		Mockito.verify(orderDao, Mockito.times(1)).update(order);
	}
	
	@Test
	public void itemServicesDelete() {
		orderServices.delete(1);;
		Mockito.verify(orderDao, Mockito.times(1)).delete(1);
	}
}
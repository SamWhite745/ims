package com.qa.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.databaseobjects.Customer;
import com.qa.services.CustomerService;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerIT {
	
	/**
	 *  The thing I want to fake functionality for
	 */
	@Mock
	private CustomerService customerService;
	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer controller
	 */
	@Spy
	@InjectMocks
	private CustomerController customerController;

	@Test
	public void readAllTest() {		
		customerController.readAll();
		Mockito.verify(customerService, Mockito.times(1)).readAll();
	}

	@Test
	public void createTest() {
		String name = "Sam White";
		Mockito.doReturn(name).when(customerController).getStringInput();
		Customer customer = new Customer(name);
		customerController.create();
		Mockito.verify(customerService, Mockito.times(1)).create(customer);
	}

	@Test
	public void updateTest() {
		String name = "Sam White";
		
		Mockito.doReturn("1", name).when(customerController).getStringInput();

		Customer customer = new Customer(1, name);
		customerController.update();
		Mockito.verify(customerService, Mockito.times(1)).update(customer);
	}
	
	@Test
	public void deleteTest() {
		Mockito.doReturn("1").when(customerController).getStringInput();
		customerController.delete();
		Mockito.verify(customerService, Mockito.times(1)).delete(1);
	}
	
}
package com.qa.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.databasemanipulation.CustomerDao;
import com.qa.databasemanipulation.DAO;
import com.qa.databaseobjects.Customer;


@RunWith(MockitoJUnitRunner.class)
public class CustomerServicesTest {
	
	@Mock
	private CustomerDao customerDao;
	
	@InjectMocks
	private CustomerService customerServices;
	
	@Test
	public void customerServicesCreate() {
		Customer customer = new Customer("Sam White");
		customerServices.create(customer);
		Mockito.verify(customerDao, Mockito.times(1)).create(customer);
	}
	
	@Test
	public void customerServicesRead() {
		customerServices.readAll();
		Mockito.verify(customerDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void customerServicesUpdate() {
		Customer customer = new Customer("Sam White");
		customerServices.update(customer);
		Mockito.verify(customerDao, Mockito.times(1)).update(customer);
	}
	
	@Test
	public void customerServicesDelete() {
		customerServices.delete(1);;
		Mockito.verify(customerDao, Mockito.times(1)).delete(1);
	}
}
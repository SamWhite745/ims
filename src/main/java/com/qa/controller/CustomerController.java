package com.qa.controller;

import com.qa.databaseObjects.Customer;
import com.qa.ims.Utils;
import com.qa.services.CrudService;

public class CustomerController implements CrudController<Customer> {

	private CrudService<Customer> customerService;

	public CustomerController(CrudService<Customer> customerService) {
		this.customerService = customerService;
	}

	@Override
	public void readAll() {
		System.out.println(customerService.readAll());
	}

	@Override
	public void create() {
		System.out.println("What is the name of the customer?");
		String name = Utils.getStringInput();
		Customer cust = new Customer(name);
		customerService.create(cust);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

}

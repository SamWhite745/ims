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
		customerService.readAll().stream().forEach(customer -> System.out.println(customer.toString()));
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
		System.out.println("Which customer (by id) do you want to update");
		int id = Utils.getIntInput();
		System.out.println("What is the name of the customer");
		String name = Utils.getStringInput();
		Customer customer = new Customer(id, name);
		customerService.update(customer);	

	}

	@Override
	public void delete() {
		System.out.println("What is the customer Id you want to delete?");
		int id = Utils.getIntInput();
		customerService.delete(id);
		System.out.println("Successfully deleted");
	}

}

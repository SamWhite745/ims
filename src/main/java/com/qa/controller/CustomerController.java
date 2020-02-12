package com.qa.controller;

import org.apache.log4j.Logger;

import com.qa.databaseObjects.Customer;
import com.qa.ims.Utils;
import com.qa.services.CrudService;

public class CustomerController implements CrudController<Customer> {
	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	private CrudService<Customer> customerService;

	public CustomerController(CrudService<Customer> customerService) {
		this.customerService = customerService;
	}

	@Override
	public void readAll() {
		customerService.readAll().stream().forEach(customer -> System.out.println(customer.toString()));
	}

	@Override
	public void create() {
		LOGGER.info("What is the name of the customer?");
		String name = Utils.getStringInput();
		Customer cust = new Customer(name);
		customerService.create(cust);
	}

	@Override
	public void update() {
		LOGGER.info("Which customer (by id) do you want to update");
		int id = Utils.getIntInput();
		LOGGER.info("What is the name of the customer");
		String name = Utils.getStringInput();
		Customer customer = new Customer(id, name);
		customerService.update(customer);	

	}

	@Override
	public void delete() {
		LOGGER.info("What is the customer Id you want to delete?");
		int id = Utils.getIntInput();
		customerService.delete(id);
		LOGGER.info("Successfully deleted");
	}

}

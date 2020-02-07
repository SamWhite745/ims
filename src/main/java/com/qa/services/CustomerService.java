package com.qa.services;

import java.util.List;

import com.qa.databaseObjects.Customer;
import com.qa.databasemanipulation.CustomerDao;

public class CustomerService implements CrudService<Customer> {

	CustomerDao custDao;

	public CustomerService(CustomerDao custDao) {
		this.custDao = custDao;
	}

	@Override
	public List<Customer> readAll() {
		return custDao.readAll();
	}

	@Override
	public void create(Customer t) {
		custDao.create(t);

	}

	@Override
	public void update(long id, Customer t) {

	}

	@Override
	public void delete(Customer t) {
		// TODO Auto-generated method stub

	}

}

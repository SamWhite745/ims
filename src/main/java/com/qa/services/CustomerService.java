package com.qa.services;

import java.util.List;

import com.qa.databaseObjects.Customer;
import com.qa.databasemanipulation.CustomerDao;

public class CustomerService implements CrudService<Customer> {
	private CustomerDao custDao;

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
	public void update(Customer t) {
		custDao.update(t);
	}

	@Override
	public void delete(int id) {
		custDao.delete(id);
	}

}

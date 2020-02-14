package com.qa.services;

import java.util.List;

import com.qa.databasemanipulation.CustomerDao;
import com.qa.databaseobjects.Customer;

/**
 * @author Sam service for moving calls from Controller to Customer Dao
 *
 */
public class CustomerService implements CrudService<Customer> {
	private CustomerDao custDao;

	/**
	 * @param custDao
	 */
	public CustomerService(CustomerDao custDao) {
		this.custDao = custDao;
	}

	/**
	 * @return returns a list of customers from the DAO
	 */
	@Override
	public List<Customer> readAll() {
		return custDao.readAll();
	}

	/**
	 *
	 */
	@Override
	public void create(Customer t) {
		custDao.create(t);
	}

	/**
	 *
	 */
	@Override
	public void update(Customer t) {
		custDao.update(t);
	}

	/**
	 *
	 */
	@Override
	public void delete(int id) {
		custDao.delete(id);
	}

}

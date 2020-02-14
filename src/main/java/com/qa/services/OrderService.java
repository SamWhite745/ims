package com.qa.services;

import java.util.List;

import com.qa.databasemanipulation.OrderDao;
import com.qa.databaseobjects.Order;

/**
 * @author Sam service for moving calls from Controller to Order Dao
 *
 */
public class OrderService implements CrudService<Order> {
	private OrderDao orderDao;

	/**
	 * @param orderDao
	 */
	public OrderService(OrderDao orderDao ) {
		this.orderDao = orderDao;
	}
	
	/**
	 * @return returns a list of orders from the DAO
	 */
	@Override
	public List<Order> readAll() {
		return orderDao.readAll();
	}

	/**
	 * @param Order passes a order to the DAO
	 */
	@Override
	public void create(Order t) {
		orderDao.create(t);
	}

	/**
	 * @param Order passes a order to update to the DAO
	 */
	@Override
	public void update(Order t) {
		orderDao.update(t);		
	}

	/**
	 * @param id passes the id of an order to delete to the DAO
	 */
	@Override
	public void delete(int id) {
		orderDao.delete(id);		
	}

}

package com.qa.services;

import java.util.List;

import com.qa.databasemanipulation.OrderDao;
import com.qa.databaseobjects.Order;

public class OrderService implements CrudService<Order> {
	private OrderDao orderDao;

	public OrderService(OrderDao orderDao ) {
		this.orderDao = orderDao;
	}
	
	@Override
	public List<Order> readAll() {
		return orderDao.readAll();
	}

	@Override
	public void create(Order t) {
		orderDao.create(t);
	}

	@Override
	public void update(Order t) {
		orderDao.update(t);		
	}

	@Override
	public void delete(int id) {
		orderDao.delete(id);		
	}

}

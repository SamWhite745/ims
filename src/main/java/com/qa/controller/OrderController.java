package com.qa.controller;

import java.util.ArrayList;
import java.util.List;

import com.qa.databaseObjects.Customer;
import com.qa.databaseObjects.Item;
import com.qa.databaseObjects.ItemOrders;
import com.qa.databaseObjects.Order;
import com.qa.databasemanipulation.CustomerDao;
import com.qa.databasemanipulation.ItemDao;
import com.qa.databasemanipulation.ItemOrdersDao;
import com.qa.databasemanipulation.OrderDao;
import com.qa.ims.Utils;
import com.qa.services.CrudService;
import com.qa.services.ItemOrdersService;

public class OrderController implements CrudController<Order> {
	
	private CrudService<Order> orderService;
	private CrudService<ItemOrders> itemOrderService;
	
	public OrderController(CrudService<Order> orderService) {
		this.orderService = orderService;
		this.itemOrderService = new ItemOrdersService(new ItemOrdersDao());
	}
	
	/*
	 * 	public ItemOrders(int itemId, int orderId, int quantity, int itemCost) {
		this.itemId = itemId;
		this.orderId = orderId;
		this.quantity = quantity;
		this.itemCost = itemCost;
	}
	 */
	
	@Override
	public void create() {
		System.out.println("Which customer is this for? (id)");
		int customerId = Utils.getIntInput();
		
		CustomerDao custDao = new CustomerDao();
		Customer cust = custDao.getCustomer(customerId);
		
		orderService.create(new Order(cust));
		
		OrderDao orderDao = new OrderDao();
		int orderId = orderDao.readLatest();
		
		System.out.println("What item do you want to add to the order? (id)");
		int itemId = Utils.getIntInput();

		ItemDao itemDao = new ItemDao();
		Item item = itemDao.getItem(itemId);

		System.out.println("How many of this item do you want?");
		int quantity = Utils.getIntInput();
		
		ItemOrders iOrder = new ItemOrders(item.getId(), orderId, quantity, item.getValue()*quantity);
		itemOrderService.create(iOrder);
		
		System.out.println("Order successfully created");
	}

	@Override
	public void readAll() {
		// TODO Auto-generated method stub

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

package com.qa.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.databasemanipulation.CustomerDao;
import com.qa.databasemanipulation.ItemDao;
import com.qa.databasemanipulation.ItemOrdersDao;
import com.qa.databasemanipulation.OrderDao;
import com.qa.databaseobjects.Customer;
import com.qa.databaseobjects.Item;
import com.qa.databaseobjects.ItemOrders;
import com.qa.databaseobjects.Order;
import com.qa.ims.Config;
import com.qa.ims.Utils;
import com.qa.services.CrudService;
import com.qa.services.ItemOrdersService;

public class OrderController implements CrudController {
	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudService<Order> orderService;
	private ItemOrdersService itemOrderService;

	public OrderController(CrudService<Order> orderService) {
		this.orderService = orderService;
		this.itemOrderService = new ItemOrdersService(new ItemOrdersDao(Config.getUsername(), Config.getPassword()));
	}

	@Override
	public void create() {
		LOGGER.info("Which customer is this for? (id)");
		int customerId = Integer.parseInt(getStringInput());

		CustomerDao custDao = new CustomerDao(Config.getUsername(), Config.getPassword());
		Customer cust = custDao.getCustomer(customerId);

		orderService.create(new Order(cust));

		OrderDao orderDao = new OrderDao(Config.getUsername(), Config.getPassword());
		int orderId = orderDao.readLatest();

		LOGGER.info("What item do you want to add to the order? (id)");
		int itemId = Integer.parseInt(getStringInput());

		ItemDao itemDao = new ItemDao(Config.getUsername(), Config.getPassword());
		Item item = itemDao.getItem(itemId);

		LOGGER.info("How many of this item do you want?");
		int quantity = Integer.parseInt(getStringInput());

		ItemOrders iOrder = new ItemOrders(item.getId(), orderId, quantity, item.getValue() * quantity);
		itemOrderService.create(iOrder);

		LOGGER.info("Order successfully created");
	}

	@Override
	public void readAll() {
		List<Order> orders = orderService.readAll();
		for (Order order : orders) {
			LOGGER.info(order.toString());
			itemOrderService.readAll().stream().filter(itemOrder -> itemOrder.getOrder() == order.getId())
					.forEach(iOrders -> LOGGER.info(iOrders.toString()));
		}
	}

	@Override
	public void update() {
		LOGGER.info("Do you want to: ");
		LOGGER.info("1 : update the order");
		LOGGER.info("2 : update an item in the order");
		LOGGER.info("3 : delete an item from the order");
		LOGGER.info("4 : add an item to the order");
		int selection = Integer.parseInt(getStringInput());

		switch (selection) {
		case 1:
			LOGGER.info("new name: ");
			String name = getStringInput();
			LOGGER.info("For which id: ");
			int id = Integer.parseInt(getStringInput());

			CustomerDao custDao = new CustomerDao(Config.getUsername(), Config.getPassword());
			Customer cust = custDao.getCustomer(id);
			cust.setName(name);
			orderService.update(new Order(id, cust));
			break;
		case 2:
			LOGGER.info("Which itemOrder id do you want to update");
			int itemOrderId = Integer.parseInt(getStringInput());

			LOGGER.info("What is the new item id?: ");
			int itemId = Integer.parseInt(getStringInput());

			LOGGER.info("What is the new order id?: ");
			int orderId = Integer.parseInt(getStringInput());

			LOGGER.info("What is the new quantity?: ");
			int quantity = Integer.parseInt(getStringInput());

			ItemDao itemDao = new ItemDao(Config.getUsername(), Config.getPassword());
			int itemCost = itemDao.getItem(itemId).getValue() * quantity;

			itemOrderService.update(new ItemOrders(itemOrderId, itemId, orderId, quantity, itemCost));
			break;
		case 3:
			LOGGER.info("Which item order do you want to delete? (id)");
			int itemDeleteId = Integer.parseInt(getStringInput());
			itemOrderService.delete(itemDeleteId);
			break;
		case 4:
			LOGGER.info("What is the item id?: ");
			int newItemId = Integer.parseInt(getStringInput());

			LOGGER.info("What is the order id?: ");
			int newOrderId = Integer.parseInt(getStringInput());

			LOGGER.info("What is the quantity?: ");
			int newQuantity = Integer.parseInt(getStringInput());

			ItemDao newItemDao = new ItemDao(Config.getUsername(), Config.getPassword());
			int newItemCost = newItemDao.getItem(newItemId).getValue() * newQuantity;

			itemOrderService.create(new ItemOrders(newItemId, newOrderId, newQuantity, newItemCost));
			break;
		default:
			LOGGER.info("Invalid option");
			break;
		}
	}

	@Override
	public void delete() {
		LOGGER.info("Which order do you want to delete? (id)");
		int orderId = Integer.parseInt(getStringInput());

		itemOrderService.deleteByOrder(orderId);
		orderService.delete(orderId);
	}
	

	public String getStringInput() {
		return Utils.getStringInput();
	}
}

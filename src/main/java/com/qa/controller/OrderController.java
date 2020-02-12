package com.qa.controller;

import org.apache.log4j.Logger;

import com.qa.databaseObjects.Customer;
import com.qa.databaseObjects.Item;
import com.qa.databaseObjects.ItemOrders;
import com.qa.databaseObjects.Order;
import com.qa.databasemanipulation.CustomerDao;
import com.qa.databasemanipulation.ItemDao;
import com.qa.databasemanipulation.ItemOrdersDao;
import com.qa.databasemanipulation.OrderDao;
import com.qa.ims.Config;
import com.qa.ims.Utils;
import com.qa.services.CrudService;
import com.qa.services.ItemOrdersService;

public class OrderController implements CrudController<Order> {
	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudService<Order> orderService;
	private ItemOrdersService itemOrderService;

	public OrderController(CrudService<Order> orderService) {
		this.orderService = orderService;
		this.itemOrderService = new ItemOrdersService(new ItemOrdersDao());
	}

	@Override
	public void create() {
		LOGGER.info("Which customer is this for? (id)");
		int customerId = Utils.getIntInput();

		CustomerDao custDao = new CustomerDao(Config.getUsername(), Config.getPassword());
		Customer cust = custDao.getCustomer(customerId);

		orderService.create(new Order(cust));

		OrderDao orderDao = new OrderDao();
		int orderId = orderDao.readLatest();

		LOGGER.info("What item do you want to add to the order? (id)");
		int itemId = Utils.getIntInput();

		ItemDao itemDao = new ItemDao();
		Item item = itemDao.getItem(itemId);

		LOGGER.info("How many of this item do you want?");
		int quantity = Utils.getIntInput();

		ItemOrders iOrder = new ItemOrders(item.getId(), orderId, quantity, item.getValue() * quantity);
		itemOrderService.create(iOrder);

		LOGGER.info("Order successfully created");
	}

	@Override
	public void readAll() {
		for (Order order : orderService.readAll()) {
			LOGGER.info(order.toString());
			itemOrderService.readAll().stream().filter(itemOrder -> itemOrder.getOrder() == order.getId())
					.forEach(iOrders -> System.out.println(iOrders.toString()));
		}
	}

	@Override
	public void update() {
		LOGGER.info("Do you want to: ");
		LOGGER.info("1 : update the order");
		LOGGER.info("2 : update an item in the order");
		LOGGER.info("3 : delete an item from the order");
		LOGGER.info("4 : add an item to the order");
		int selection = Utils.getIntInput();

		switch (selection) {
		case 1:
			LOGGER.info("new name: ");
			String name = Utils.getStringInput();
			LOGGER.info("For which id: ");
			int id = Utils.getIntInput();

			CustomerDao custDao = new CustomerDao(Config.getUsername(), Config.getPassword());
			Customer cust = custDao.getCustomer(id);
			cust.setName(name);
			orderService.update(new Order(id, cust));
			break;
		case 2:
			LOGGER.info("Which itemOrder id do you want to update");
			int itemOrderId = Utils.getIntInput();

			LOGGER.info("What is the new item id?: ");
			int itemId = Utils.getIntInput();

			LOGGER.info("What is the new order id?: ");
			int orderId = Utils.getIntInput();

			LOGGER.info("What is the new quantity?: ");
			int quantity = Utils.getIntInput();

			ItemDao itemDao = new ItemDao();
			int itemCost = itemDao.getItem(itemId).getValue() * quantity;

			itemOrderService.update(new ItemOrders(itemOrderId, itemId, orderId, quantity, itemCost));
			break;
		case 3:
			LOGGER.info("Which item order do you want to delete? (id)");
			int itemDeleteId = Utils.getIntInput();
			itemOrderService.delete(itemDeleteId);
			break;
		case 4:
			LOGGER.info("What is the item id?: ");
			int newItemId = Utils.getIntInput();

			LOGGER.info("What is the order id?: ");
			int newOrderId = Utils.getIntInput();

			LOGGER.info("What is the quantity?: ");
			int newQuantity = Utils.getIntInput();

			ItemDao newItemDao = new ItemDao();
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
		int orderId = Utils.getIntInput();

		itemOrderService.deleteByOrder(orderId);
		orderService.delete(orderId);
	}

}

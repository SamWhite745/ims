package com.qa.controller;


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

		ItemOrders iOrder = new ItemOrders(item.getId(), orderId, quantity, item.getValue() * quantity);
		itemOrderService.create(iOrder);

		System.out.println("Order successfully created");
	}

	@Override
	public void readAll() {
		for (Order order : orderService.readAll()) {
			System.out.println(order.toString());
			itemOrderService.readAll().stream().filter(itemOrder -> itemOrder.getOrder() == order.getId())
					.forEach(iOrders -> System.out.println(iOrders.toString()));
		}
	}

	@Override
	public void update() {
		System.out.println("Do you want to: ");
		System.out.println("1 : update the order");
		System.out.println("2 : update an item in the order");
		System.out.println("3 : delete an item from the order");
		System.out.println("4 : add an item to the order");
		int selection = Utils.getIntInput();
		
		switch (selection) {
		case 1:
			System.out.println("new name: ");
			String name = Utils.getStringInput();
			System.out.println("For which id: ");
			int id = Utils.getIntInput();
			
			CustomerDao custDao = new CustomerDao();
			Customer cust = custDao.getCustomer(id);
			cust.setName(name);
			orderService.update(new Order(id, cust));
			break;
		case 2:
			System.out.println("Which itemOrder id do you want to update");
			int itemOrderId = Utils.getIntInput();
			
			System.out.println("What is the new item id?: ");
			int itemId = Utils.getIntInput();
			
			System.out.println("What is the new order id?: ");
			int orderId = Utils.getIntInput();
			
			System.out.println("What is the new quantity?: ");
			int quantity = Utils.getIntInput();
			
			ItemDao itemDao = new ItemDao();
			int itemCost = itemDao.getItem(itemId).getValue() * quantity;
						
			itemOrderService.update(new ItemOrders(itemOrderId, itemId, orderId, quantity, itemCost));
			break;
		case 3: 
			System.out.println("Which item order do you want to delete? (id)");
			int itemDeleteId = Utils.getIntInput();
			itemOrderService.delete(itemDeleteId);
			break;
		case 4:			
			System.out.println("What is the item id?: ");
			int newItemId = Utils.getIntInput();
			
			System.out.println("What is the order id?: ");
			int newOrderId = Utils.getIntInput();
			
			System.out.println("What is the quantity?: ");
			int newQuantity = Utils.getIntInput();
			
			ItemDao newItemDao = new ItemDao();
			int newItemCost = newItemDao.getItem(newItemId).getValue() * newQuantity;
						
			itemOrderService.create(new ItemOrders(newItemId, newOrderId, newQuantity, newItemCost));
			break;
		default:
			System.out.println("Invalid option");
			break;
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

}

package com.qa.ims;

import org.apache.log4j.Logger;

import com.qa.controller.CrudController;
import com.qa.controller.CustomerController;
import com.qa.controller.ItemController;
import com.qa.controller.OrderController;
import com.qa.databasemanipulation.*;
import com.qa.services.CustomerService;
import com.qa.services.ItemService;
import com.qa.services.OrderService;

public class Controller {

	public static final Logger LOGGER = Logger.getLogger(Controller.class);

	
	public void start() {
		boolean actionLoop = false;
		LOGGER.info("Username: ");
		Config.setUsername(Utils.getStringInput());
		LOGGER.info("Password: ");
		Config.setPassword(Utils.getStringInput());
		
		while (!actionLoop) {
			LOGGER.info("What would you like to do?");
			LOGGER.info("1 Create");
			LOGGER.info("2 View");
			LOGGER.info("3 Update");
			LOGGER.info("4 Delete");
			LOGGER.info("5 Exit");
			int action = Integer.parseInt(Utils.getStringInput());
			if (action == 5) actionLoop = true;
			
			boolean dbLoop = false;
			while (!dbLoop && !actionLoop) {
				LOGGER.info("What database would you like to use?");
				LOGGER.info("1 Item");
				LOGGER.info("2 Customer");
				LOGGER.info("3 Order");
				LOGGER.info("4 Back");

				int database = Integer.parseInt(Utils.getStringInput());

				switch (database) {
				case 1:
					ItemController itemController = new ItemController(new ItemService(new ItemDao(Config.getUsername(), Config.getPassword())));
					action(itemController, action);
					break;
				case 2:
					CustomerController custController = new CustomerController(new CustomerService(new CustomerDao(Config.getUsername(), Config.getPassword())));
					action(custController, action);
					break;
				case 3:
					OrderController orderController = new OrderController(new OrderService(new OrderDao(Config.getUsername(), Config.getPassword())));
					action(orderController, action);
					break;
				case 4:
					dbLoop = true;
					break;
				default:
					LOGGER.info("Invalid action");
					break;
				}
			}

		}

	}

	private void action(CrudController crudController, int action) {
		switch (action) {
		case 1:
			crudController.create();
			break;
		case 2:
			crudController.readAll();
			break;
		case 3:
			crudController.update();
			break;
		case 4:
			crudController.delete();
			break;
		default:
			LOGGER.info("Invalid action");
			break;
		}
	}
}

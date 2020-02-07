package com.qa.ims;


import com.qa.controller.CrudController;
import com.qa.controller.CustomerController;
import com.qa.controller.ItemController;
import com.qa.databasemanipulation.*;
import com.qa.services.CustomerService;
import com.qa.services.ItemService;

public class Controller {

	public void start() {
		boolean looper = false;
		while (!looper) {
			System.out.println("What would you like to do?");
			System.out.println("1 Create");
			System.out.println("2 View");
			System.out.println("3 Update");
			System.out.println("4 Delete");
			System.out.println("5 Exit");
			int action = Utils.getIntInput();

			System.out.println();
			System.out.println("What database would you like to use?");
			System.out.println("1 Item");
			System.out.println("2 Customer");
			System.out.println("3 Order");
			System.out.println("4 Back");

			int database = Utils.getIntInput();

			switch (database) {
			case 1:
				ItemController itemController = new ItemController(new ItemService(new ItemDao()));
				action(itemController, action);
				break;
			case 2:
				CustomerController custController = new CustomerController(new CustomerService(new CustomerDao()));
				action(custController, action);
				break;
			case 3:
				break;
			case 4:
				looper = true;
				break;
			}
		}

	}

	private void action(CrudController<?> crudController, int action) {
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
		}
	}

//	System.out.println("Which customer id do you want to add an order for?");
//	ResultSet rs = stmt.executeQuery("select * from customers");
//	while (rs.next())
//		System.out.println(rs.getInt(1) + "  " + rs.getString(2));
//	int id = Utils.getIntInput();
//	String query = " INSERT INTO order (name)" + " values (?)";
//	PreparedStatement preparedStmt = con.prepareStatement(query);
//	preparedStmt.setInt(1, id);
//	preparedStmt.execute();
//	break;
}

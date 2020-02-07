package com.qa.databasemanipulation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.qa.databaseObjects.Customer;
import com.qa.databaseObjects.Order;
import com.qa.databaseObjects.Order;
import com.qa.ims.Config;

public class OrderDao implements DAO<Order> {
	private Connection connection;

	public OrderDao() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:mysql://35.246.47.159:3306/management_database",
				Config.username, Config.password);
	}

	public void create(Order t) {
		// TODO Auto-generated method stub

	}

	public void update(Order t) {
		// TODO Auto-generated method stub

	}

	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = new ArrayList<Order>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM orders");
			while (rs.next()) {
				int id = rs.getInt("id");
				int custId = rs.getInt("customer_id");

				CustomerDao custDao = new CustomerDao();
				Customer cust = custDao.readAll().stream().filter(customer -> customer.getId() == custId).findFirst().orElse(null);
				if (cust.equals(null)) System.out.println("not a customer");
				else {
					Order order = new Order(id, cust);
					orders.add(order);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}
}

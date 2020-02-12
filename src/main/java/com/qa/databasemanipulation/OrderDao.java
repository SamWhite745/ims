package com.qa.databasemanipulation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qa.databaseObjects.Customer;
import com.qa.databaseObjects.ItemOrders;
import com.qa.databaseObjects.Order;
import com.qa.ims.Config;

public class OrderDao implements DAO<Order> {
	private Connection connection;
	private ItemOrdersDao itemOrdersDao = new ItemOrdersDao();

	public OrderDao() {
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://35.246.47.159:3306/management_database",
					Config.username, Config.password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void create(Order t) {
		try {
			String query = "INSERT INTO orders (customer_id) values (?)";
			PreparedStatement preparedStmt;
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, t.getCustomer().getId());
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
				Customer cust = custDao.getCustomer(custId);

				Order order = new Order(id, cust, itemOrdersDao.readByOrder(id));
				orders.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public void update(Order t) {
		try {
			String query = "UPDATE orders SET customer_id = ? WHERE id = ?";
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, t.getCustomer().getId());
			preparedStmt.setInt(2, t.getId());
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			String query = "DELETE FROM orders WHERE id = ?";
			PreparedStatement preparedStmt;
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, id);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int readLatest() {
		int latestId = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM customers ORDER BY id DESC LIMIT 1");
			resultSet.next();
			latestId = resultSet.getInt("id");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return latestId;
	}

//	public Order getOrder(int id) {
//		Order order = null;
//		try {
//			String query = "SELECT * FROM orders WHERE id = ?";
//			PreparedStatement preparedStmt = connection.prepareStatement(query);
//			preparedStmt.setInt(1, id);
//			ResultSet rs = preparedStmt.executeQuery();
//			while (rs.next()) {
//				int orderId = rs.getInt("id");
//				CustomerDao custDao = new CustomerDao();
//				
//				order = new Order(orderId, custDao.getCustomer(id));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return order;
//	}
}

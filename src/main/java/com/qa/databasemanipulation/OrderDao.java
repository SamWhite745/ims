package com.qa.databasemanipulation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.databaseobjects.Customer;
import com.qa.databaseobjects.Order;
import com.qa.ims.Config;

public class OrderDao implements DAO<Order> {
	public static final Logger LOGGER = Logger.getLogger(OrderDao.class);
	
	private ItemOrdersDao itemOrdersDao = new ItemOrdersDao(Config.getUsername(), Config.getPassword());


	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public OrderDao(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://35.246.47.159:3306/management_database";
		this.username = username;
		this.password = password;
	}

	public OrderDao(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	@Override
	public void create(Order t) {
		String query = "INSERT INTO orders (customer_id) values (?)";

		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement preparedStmt = connection.prepareStatement(query);){

			preparedStmt.setInt(1, t.getCustomer().getId());
			preparedStmt.execute();
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = new ArrayList<Order>();
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM orders");){
			while (rs.next()) {
				int id = rs.getInt("id");
				int custId = rs.getInt("customer_id");

				CustomerDao custDao = new CustomerDao(Config.getUsername(), Config.getPassword());
				Customer cust = custDao.getCustomer(custId);

				Order order = new Order(id, cust, itemOrdersDao.readByOrder(id));
				orders.add(order);
			}
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return orders;
	}

	@Override
	public void update(Order t) {
		String query = "UPDATE orders SET customer_id = ? WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement preparedStmt = connection.prepareStatement(query);){
			preparedStmt.setInt(1, t.getCustomer().getId());
			preparedStmt.setInt(2, t.getId());
			preparedStmt.execute();
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		String query = "DELETE FROM orders WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement preparedStmt = connection.prepareStatement(query);){
			preparedStmt.setInt(1, id);
			preparedStmt.execute();
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	public int readLatest() {
		int latestId = 0;
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY id DESC LIMIT 1");){
			resultSet.next();
			latestId = resultSet.getInt("id");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return latestId;
	}
}

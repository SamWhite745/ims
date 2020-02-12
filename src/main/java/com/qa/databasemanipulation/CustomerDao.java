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

public class CustomerDao implements DAO<Customer> {
	public static final Logger LOGGER = Logger.getLogger(CustomerDao.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public CustomerDao(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://35.246.47.159:3306/management_database";
		this.username = username;
		this.password = password;
	}

	public CustomerDao(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	@Override
	public void create(Customer t) {
		String query = " INSERT INTO customers (name) VALUES (?)";

		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement preparedStmt = connection.prepareStatement(query);) {
			preparedStmt.setString(1, t.getName());
			preparedStmt.execute();
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}

	}

	@Override
	public List<Customer> readAll() {
		List<Customer> customers = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM customers");) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Customer customer = new Customer(id, name);
				customers.add(customer);
			}
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return customers;

	}

	@Override
	public void update(Customer t) {
		String query = "UPDATE customers SET name = ? WHERE id = ?";
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement preparedStmt = connection.prepareStatement(query);) {
			preparedStmt.setString(1, t.getName());
			preparedStmt.setInt(2, t.getId());
			preparedStmt.execute();
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		String query = "DELETE FROM customers WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement preparedStmt = connection.prepareStatement(query);) {
			preparedStmt.setInt(1, id);
			preparedStmt.execute();
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	public Customer getCustomer(int id) {
		Customer customer = null;
		String query = "SELECT * FROM customers WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement preparedStmt = connection.prepareStatement(query);) {
			preparedStmt.setInt(1, id);
			try (ResultSet rs = preparedStmt.executeQuery();){
				while (rs.next()) {
					int custId = rs.getInt("id");
					String name = rs.getString("name");
					customer = new Customer(custId, name);
				}
			}
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return customer;
	}
}

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

import com.qa.databaseObjects.Customer;
import com.qa.ims.Config;

public class CustomerDao implements DAO<Customer> {
	private Connection connection;
	public static final Logger LOGGER = Logger.getLogger(CustomerDao.class);


	public CustomerDao() {
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://35.246.47.159:3306/management_database",
					Config.getUsername(), Config.getPassword());
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	
	@Override
	public void create(Customer t) {
		try {
			String query = " INSERT INTO customers (name)" + " values (?)";
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, t.getName());
			preparedStmt.execute();
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}

	}

	@Override
	public List<Customer> readAll() {
		List<Customer> customers = new ArrayList<Customer>();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
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
	public void update(Customer t){
		try {
			String query = "UPDATE customers SET name = ? WHERE id = ?";
			PreparedStatement preparedStmt = connection.prepareStatement(query);
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
		try {
			String query = "DELETE FROM customers WHERE id = ?";
			PreparedStatement preparedStmt;
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, id);
			preparedStmt.execute();
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	
	public Customer getCustomer(int id) {
		Customer customer = null;
		try {
			String query = "SELECT * FROM customers WHERE id = ?";
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, id);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				int custId = rs.getInt("id");
				String name = rs.getString("name");
				customer = new Customer(custId, name);
			}
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return customer;
	}
}

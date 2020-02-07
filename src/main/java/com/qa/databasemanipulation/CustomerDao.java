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
import com.qa.ims.Config;

public class CustomerDao implements DAO<Customer> {
	private Connection connection;

	public CustomerDao() {
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://35.246.47.159:3306/management_database",
					Config.username, Config.password);
		} catch (SQLException e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void create(Customer t) {
		try {
			String query = " INSERT INTO customers (name)" + " values (?)";
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, t.getName());
			preparedStmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getStackTrace());
		}

	}

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
				System.out.println(e.getStackTrace());
		} 
		return customers;

	}

	public void update(Customer t) throws SQLException {
		try {
			String query = "UPDATE customers SET name = ? WHERE id = ?";
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, t.getName());
			preparedStmt.setInt(2, t.getId());
			preparedStmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getStackTrace());
		}
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}

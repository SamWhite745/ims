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

import com.qa.databaseobjects.Item;

public class ItemDao implements DAO<Item> {
	public static final Logger LOGGER = Logger.getLogger(ItemDao.class);


	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public ItemDao(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://35.246.47.159:3306/management_database";
		this.username = username;
		this.password = password;
	}

	public ItemDao(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}
	
	@Override
	public void create(Item t) {
		String query = " INSERT INTO items (name, value) values (?, ?)";

		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement preparedStmt = connection.prepareStatement(query);){
			preparedStmt.setString(1, t.getName());
			preparedStmt.setInt(2, t.getValue());
			preparedStmt.execute();
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	
	@Override
	public List<Item> readAll() {
		List<Item> items = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM items");){
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int value = rs.getInt("value");
				Item item = new Item(id, name, value);
				items.add(item);
			}
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());

		}
		return items;
	}
	
	@Override
	public void update(Item t) {
		String query = "UPDATE items SET name = ?, value = ? WHERE id = ?";
		
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement preparedStmt = connection.prepareStatement(query);){
			preparedStmt.setString(1, t.getName());
			preparedStmt.setInt(2, t.getValue());
			preparedStmt.setInt(3, t.getId());
			preparedStmt.execute();
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		String query = "DELETE FROM items WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement preparedStmt = connection.prepareStatement(query);){
			preparedStmt.setInt(1, id);
			preparedStmt.execute();
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	
	public Item getItem(int id) {
		Item item = null;
		String query = "SELECT * FROM items WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement preparedStmt = connection.prepareStatement(query);){
			preparedStmt.setInt(1, id);
			try (ResultSet rs = preparedStmt.executeQuery();) {
				while (rs.next()) {
					int itemId = rs.getInt("id");
					String name = rs.getString("name");
					int value = rs.getInt("value");
					item = new Item(itemId, name, value);
				}
			}
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return item;
	}
}

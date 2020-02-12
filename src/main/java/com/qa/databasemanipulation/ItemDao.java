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

import com.qa.databaseObjects.Item;
import com.qa.ims.Config;

public class ItemDao implements DAO<Item> {
	private Connection connection;
	public static final Logger LOGGER = Logger.getLogger(ItemDao.class);


	public ItemDao() {
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://35.246.47.159:3306/management_database",
					Config.getUsername(), Config.getPassword());
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	
	@Override
	public void create(Item t) {
		try {
			String query = " INSERT INTO items (name, value) values (?, ?)";
			PreparedStatement preparedStmt;
			preparedStmt = connection.prepareStatement(query);
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
		List<Item> items = new ArrayList<Item>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM items");
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
		try {
			String query = "UPDATE items SET name = ?, value = ? WHERE id = ?";
			PreparedStatement preparedStmt = connection.prepareStatement(query);
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
		try {
			String query = "DELETE FROM items WHERE id = ?";
			PreparedStatement preparedStmt;
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, id);
			preparedStmt.execute();
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	
	public Item getItem(int id) {
		Item item = null;
		try {
			String query = "SELECT * FROM items WHERE id = ?";
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, id);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				int itemId = rs.getInt("id");
				String name = rs.getString("name");
				int value = rs.getInt("value");
				item = new Item(itemId, name, value);
			}
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return item;
	}
}

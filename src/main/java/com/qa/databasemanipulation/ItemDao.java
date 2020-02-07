package com.qa.databasemanipulation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qa.databaseObjects.Item;
import com.qa.ims.Config;

public class ItemDao implements DAO<Item> {
	private Connection connection;

	public ItemDao() {
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://35.246.47.159:3306/management_database",
					Config.username, Config.password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void create(Item t) {
		try {
			String query = " INSERT INTO items (name, value)" + " values (?, ?)";
			PreparedStatement preparedStmt;
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, t.getName());
			preparedStmt.setInt(2, t.getValue());
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(Item t) {
		try {
		String query = "UPDATE items SET name = ?, value = ? WHERE id = ?";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setString(1, t.getName());
		preparedStmt.setInt(2, t.getValue());
		preparedStmt.setInt(3, t.getId());
		preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void delete(int id) {
		// TODO Auto-generated method stub

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
			e.printStackTrace();

		}

		return items;
	}
}
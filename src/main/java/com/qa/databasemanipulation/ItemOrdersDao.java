package com.qa.databasemanipulation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qa.databaseObjects.ItemOrders;
import com.qa.ims.Config;

public class ItemOrdersDao implements DAO<ItemOrders> {
	private Connection connection;

	public ItemOrdersDao() {
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://35.246.47.159:3306/management_database",
					Config.username, Config.password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void create(ItemOrders t) {
		try {
			String query = " INSERT INTO item_order (items_id, orders_id, quantity, items_cost) values (?, ?, ?, ?)";
			PreparedStatement preparedStmt;
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, t.getItem());
			preparedStmt.setInt(2, t.getOrder());
			preparedStmt.setInt(3, t.getQuantity());
			preparedStmt.setInt(4, t.getItemCost());
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<ItemOrders> readAll() {
		List<ItemOrders> itemOrders = new ArrayList<ItemOrders>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM item_order");
			while (rs.next()) {
				int id = rs.getInt("id");
				int itemId = rs.getInt("items_id");
				int orderId = rs.getInt("orders_id");
				int quantity = rs.getInt("quantity");
				int itemsCost = rs.getInt("items_cost");				
				
				ItemOrders itemOrder = new ItemOrders(id, itemId, orderId, quantity, itemsCost);
				itemOrders.add(itemOrder);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return itemOrders;
	}

	@Override
	public void update(ItemOrders t) {
		try {
			String query = "UPDATE item_order SET items_id = ?, orders_id = ?, quantity = ?, items_cost = ? WHERE id = ?";
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, t.getItem());
			preparedStmt.setInt(2, t.getOrder());
			preparedStmt.setInt(3, t.getQuantity());
			preparedStmt.setInt(4, t.getItemCost());
			preparedStmt.setInt(5, t.getId());
			
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		try {
			String query = "DELETE FROM item_order WHERE id = ?";
			PreparedStatement preparedStmt;
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, id);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ItemOrders> readByOrder(int orderId) {
		List<ItemOrders> itemOrders = new ArrayList<ItemOrders>();
		try {
			String query = "SELECT * FROM item_order WHERE orders_id = ?";
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, orderId);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int itemId = rs.getInt("items_id");
				int quantity = rs.getInt("quantity");
				int itemsCost = rs.getInt("items_cost");				
				
				ItemOrders itemOrder = new ItemOrders(id, itemId, orderId, quantity, itemsCost);
				itemOrders.add(itemOrder);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return itemOrders;
	}

}

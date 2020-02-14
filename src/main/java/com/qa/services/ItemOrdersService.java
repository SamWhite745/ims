package com.qa.services;

import java.util.List;

import com.qa.databasemanipulation.ItemOrdersDao;
import com.qa.databaseobjects.ItemOrders;

/**
 * @author Sam service for moving calls from Controller to Item Order Dao
 *
 */
public class ItemOrdersService implements CrudService<ItemOrders> {
	private ItemOrdersDao itemOrdersDao;

	public ItemOrdersService(ItemOrdersDao itemOrdersDao) {
		this.itemOrdersDao = itemOrdersDao;
	}
	/**
	 * @return returns a list of item orders from the DAO
	 */
	@Override
	public List<ItemOrders> readAll() {
		return itemOrdersDao.readAll();
	}

	/**
	 * @param ItemOrder passes an item order to the DAO
	 */
	@Override
	public void create(ItemOrders t) {
		itemOrdersDao.create(t);
	}

	/**
	 * @param ItemOrder passes an item order to update to the DAO
	 */
	@Override
	public void update(ItemOrders t) {
		itemOrdersDao.update(t);
	}

	/**
	 *
	 */
	@Override
	public void delete(int id) {
		itemOrdersDao.delete(id);
	}
	
	/**
	 * @param id passes the id of an order to delete to the DAO
	 */
	public void deleteByOrder(int id) {
		itemOrdersDao.deleteByOrder(id);
	}
}

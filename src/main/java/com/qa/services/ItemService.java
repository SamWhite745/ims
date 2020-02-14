package com.qa.services;

import java.util.List;

import com.qa.databasemanipulation.ItemDao;
import com.qa.databaseobjects.Item;

/**
 * @author Sam service for moving calls from Controller to Item Dao
 *
 */
public class ItemService implements CrudService<Item>{
	private ItemDao itemDao;

	/**
	 * @param itemDao
	 */
	public ItemService(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	/**
	 * @return returns a list of items from the DAO
	 */
	@Override
	public List<Item> readAll() {
		return itemDao.readAll();
	}

	/**
	 * @param Item passes a customer to the DAO
	 */
	@Override
	public void create(Item t) {
		itemDao.create(t);
	}

	/**
	 * @param Item passes a item to update to the DAO
	 */
	@Override
	public void update(Item t) {
		itemDao.update(t);
	}

	/**
	 * @param id passes the id of an item to delete to the DAO
	 */
	@Override
	public void delete(int id) {
		itemDao.delete(id);
	}

}

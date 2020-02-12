package com.qa.services;

import java.util.List;

import com.qa.databaseObjects.Item;
import com.qa.databasemanipulation.ItemDao;

public class ItemService implements CrudService<Item>{
	private ItemDao itemDao;

	public ItemService(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	@Override
	public List<Item> readAll() {
		return itemDao.readAll();
	}

	@Override
	public void create(Item t) {
		itemDao.create(t);
	}

	@Override
	public void update(Item t) {
		itemDao.update(t);
	}

	@Override
	public void delete(int id) {
		itemDao.delete(id);
	}

}

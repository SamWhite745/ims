package com.qa.services;

import java.util.List;

import com.qa.databaseObjects.Item;
import com.qa.databasemanipulation.ItemDao;

public class ItemService implements CrudService<Item>{
	ItemDao itemDao;

	public ItemService(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	
	@Override
	public List<Item> readAll() {
		return itemDao.readAll();
	}

	@Override
	public void create(Item t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(long id, Item t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Item t) {
		// TODO Auto-generated method stub
		
	}

}

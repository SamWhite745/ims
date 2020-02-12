package com.qa.services;

import java.util.List;

import com.qa.databasemanipulation.ItemOrdersDao;
import com.qa.databaseobjects.ItemOrders;

public class ItemOrdersService implements CrudService<ItemOrders> {
	private ItemOrdersDao itemOrdersDao;

	public ItemOrdersService(ItemOrdersDao itemOrdersDao) {
		this.itemOrdersDao = itemOrdersDao;
	}
	@Override
	public List<ItemOrders> readAll() {
		return itemOrdersDao.readAll();
	}

	@Override
	public void create(ItemOrders t) {
		itemOrdersDao.create(t);
	}

	@Override
	public void update(ItemOrders t) {
		itemOrdersDao.update(t);
	}

	@Override
	public void delete(int id) {
		itemOrdersDao.delete(id);
	}
	
	public void deleteByOrder(int id) {
		itemOrdersDao.deleteByOrder(id);
	}
}

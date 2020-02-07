package com.qa.controller;

import com.qa.databaseObjects.Item;
import com.qa.ims.Utils;
import com.qa.services.CrudService;

public class ItemController implements CrudController<Item>{
	
	private CrudService<Item> itemService;

	public ItemController(CrudService<Item> itemService) {
		this.itemService = itemService;
	}
	@Override
	public void readAll() {
		System.out.println(itemService.readAll());
	}

	@Override
	public void create() {
		System.out.println("What is the name of the item you want to add?");
		String name = Utils.getStringInput();
		System.out.println("What is the value of the item?");
		int value = Utils.getIntInput();
		Item item = new Item(name, value);
		itemService.create(item);		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}

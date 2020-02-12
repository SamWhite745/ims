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
		itemService.readAll().stream().forEach(item -> System.out.println(item.toString()));
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
		System.out.println("What item id do you want to update");
		int id = Utils.getIntInput();
		System.out.println("What is the name of the item");
		String name = Utils.getStringInput();
		System.out.println("What is the value of the item?");
		int value = Utils.getIntInput();
		Item item = new Item(id, name, value);
		itemService.update(item);		
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}

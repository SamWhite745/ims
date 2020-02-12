package com.qa.controller;

import org.apache.log4j.Logger;

import com.qa.databaseObjects.Item;
import com.qa.ims.Utils;
import com.qa.services.CrudService;

public class ItemController implements CrudController<Item>{
	
	private CrudService<Item> itemService;
	public static final Logger LOGGER = Logger.getLogger(ItemController.class);

	public ItemController(CrudService<Item> itemService) {
		this.itemService = itemService;
	}
	@Override
	public void readAll() {
		itemService.readAll().stream().forEach(item -> System.out.println(item.toString()));
	}
	
	@Override
	public void create() {
		LOGGER.info("What is the name of the item you want to add?");
		String name = Utils.getStringInput();
		LOGGER.info("What is the value of the item?");
		int value = Utils.getIntInput();
		Item item = new Item(name, value);
		itemService.create(item);		
	}

	@Override
	public void update() {
		LOGGER.info("What item id do you want to update");
		int id = Utils.getIntInput();
		LOGGER.info("What is the name of the item");
		String name = Utils.getStringInput();
		LOGGER.info("What is the value of the item?");
		int value = Utils.getIntInput();
		Item item = new Item(id, name, value);
		itemService.update(item);		
		
	}

	@Override
	public void delete() {
		LOGGER.info("What is the item Id you want to delete?");
		int id = Utils.getIntInput();
		itemService.delete(id);
		LOGGER.info("Successfully deleted");
	}

}

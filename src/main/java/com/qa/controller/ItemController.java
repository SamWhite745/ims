package com.qa.controller;

import org.apache.log4j.Logger;

import com.qa.databaseobjects.Item;
import com.qa.ims.Utils;
import com.qa.services.CrudService;

public class ItemController implements CrudController {

	private CrudService<Item> itemService;
	public static final Logger LOGGER = Logger.getLogger(ItemController.class);

	public ItemController(CrudService<Item> itemService) {
		this.itemService = itemService;
	}

	@Override
	public void readAll() {
		itemService.readAll().stream().forEach(item -> LOGGER.info(item.toString()));
	}

	@Override
	public void create() {
		LOGGER.info("What is the name of the item you want to add?");
		String name = getStringInput();
		LOGGER.info("What is the value of the item?");
		int value = Integer.parseInt(getStringInput());
		Item item = new Item(name, value);
		itemService.create(item);
	}

	@Override
	public void update() {
		LOGGER.info("What item id do you want to update");
		int id = Integer.parseInt(getStringInput());
		LOGGER.info("What is the name of the item");
		String name = getStringInput();
		LOGGER.info("What is the value of the item?");
		int value = Integer.parseInt(getStringInput());
		Item item = new Item(id, name, value);
		itemService.update(item);

	}

	@Override
	public void delete() {
		LOGGER.info("What is the item Id you want to delete?");
		int id = Integer.parseInt(getStringInput());
		itemService.delete(id);
		LOGGER.info("Successfully deleted");
	}

	public String getStringInput() {
		return Utils.getStringInput();
	}
}

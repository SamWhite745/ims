package com.qa.controller;

public interface CrudController<T> {
	void create();

	void readAll();

	void update();

	void delete();

}

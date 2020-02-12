package com.qa.services;

import java.util.List;

public interface CrudService<T> {

	public List<T> readAll();

	void create(T t);

	void update(T t);

	void delete(int id);

}

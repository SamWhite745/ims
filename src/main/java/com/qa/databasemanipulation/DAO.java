package com.qa.databasemanipulation;

import java.util.List;

public interface DAO<T> {

	public void create(T t);

	public List<T> readAll();

	public void update(T t);

	public void delete(int id);
}

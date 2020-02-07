package com.qa.databasemanipulation;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

	public void create(T t) throws SQLException;

	public List<T> readAll() throws SQLException;

	public void update(T t) throws SQLException;

	public void delete(int id) throws SQLException;
}

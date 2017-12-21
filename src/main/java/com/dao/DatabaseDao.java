package com.dao;

public interface DatabaseDao {
	public void createDatabase(String url);
	public boolean databaseIsEmpty();
}

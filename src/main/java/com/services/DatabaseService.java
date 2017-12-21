package com.services;

public interface DatabaseService {
	public void createDatabase(String url);
	public boolean databaseIsEmpty();
}

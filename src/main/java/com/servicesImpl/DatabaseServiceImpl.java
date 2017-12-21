package com.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DatabaseDao;
import com.services.DatabaseService;

@Service("databaseService")
public class DatabaseServiceImpl implements DatabaseService {
	@Autowired
	DatabaseDao databaseDao;

	public void setDatabaseDao(DatabaseDao databaseDao) {
		this.databaseDao = databaseDao;
	}

	public DatabaseDao getDatabaseDao() {
		return this.databaseDao;
	}

	public void createDatabase(String url) {
		databaseDao.createDatabase(url);
	}

	public boolean databaseIsEmpty() {
		return databaseDao.databaseIsEmpty();
	}

}

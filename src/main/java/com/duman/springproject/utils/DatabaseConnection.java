package com.duman.springproject.utils;

import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log4j2
public class DatabaseConnection {

	private Connection connection;
	private static DatabaseInformation databaseInformation;

	//static block, onyl called once when class is being created in memory and that's all..It's loaded automatically, and be called before constructor.
	static {
		databaseInformation = new DatabaseInformation();
	}

	private String url = databaseInformation.getUrl();
	private String userName = databaseInformation.getUserName();
	private String password = databaseInformation.getPassword();

	private static DatabaseConnection instance;

	private DatabaseConnection() {
		try {
			Class.forName(databaseInformation.getForNameData());
			this.connection = DriverManager.getConnection(url, userName, password);
			log.info("Database connection is succeded!");
		} catch (Exception e) {
			log.info("Unwanted actions happened!");
			e.printStackTrace();
		}
	}

	public static DatabaseConnection getInstance() {
		try {
			if (instance == null) {
				instance = new DatabaseConnection();
			} else if (instance.getConnection().isClosed()) {
				instance = new DatabaseConnection();
			}
		} catch (SQLException e) {
			log.error("Singleton Failure");
			e.printStackTrace();
		}
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}

}

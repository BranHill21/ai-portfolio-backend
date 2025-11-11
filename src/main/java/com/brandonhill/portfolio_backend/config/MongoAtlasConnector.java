package com.brandonhill.portfolio_backend.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoAtlasConnector {

	private static MongoClient mongoClient;
	private static MongoDatabase database;

	// Initialize once
	public static void init(String connectionString, String dbName) {
		if (mongoClient == null) {
			mongoClient = MongoClients.create(connectionString);
			database = mongoClient.getDatabase(dbName);
			System.out.println("Connected to MongoDB Atlas: " + dbName);
		}
	}

	public static MongoDatabase getDatabase() {
		if (database == null) {
			throw new IllegalStateException("MongoAtlasConnector not initialized. Call init() first.");
		}
		return database;
	}

	// Optional: clean up on shutdown
	public static void close() {
		if (mongoClient != null) {
			mongoClient.close();
			System.out.println("MongoDB connection closed.");
		}
	}
}
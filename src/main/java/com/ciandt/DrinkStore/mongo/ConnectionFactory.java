package com.ciandt.DrinkStore.mongo;

import com.mongodb.MongoClient;

public class ConnectionFactory {
	private static MongoClient client;
	
	/**
	 * Obter o cliente do MongoDB.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return client o cliente
	 */
	public static MongoClient getMongoClient() {
		try {
			if (client == null) {
				client = new MongoClient("localhost", 27017);
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return client;
	}
}

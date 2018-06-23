package com.ciandt.DrinkStore.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.ciandt.DrinkStore.constant.Api;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class Mongo {
	/**
	 * Criar a coleção.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pCollectionName o nome da coleção
	 */
	public void createCollection(String pCollectionName) {
		getDataBase().createCollection(pCollectionName);
	}
	
	/**
	 * Deletar o documento.
	 * @param pCollectionName o nome da coleção
	 * @param pId o id
	 * @return counter o número de documentos deletados
	 */
	public long delete(String pCollectionName, ObjectId pId) {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("_id", pId);
		DeleteResult result = getCollection(pCollectionName).deleteMany(searchQuery);
		return result.getDeletedCount();
	}
	
	/**
	 * Deletar o documento.
	 * @param pCollectionName o nome da coleção
	 * @param pKey a chave
	 * @param pValue o valor
	 * @return counter o número de documentos deletados
	 */
	public long delete(String pCollectionName, String pKey, String pValue) {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put(pKey, pValue);
		DeleteResult result = getCollection(pCollectionName).deleteMany(searchQuery);
		return result.getDeletedCount();
	}
	
	/**
	 * Deletar o documento.
	 * @param pCollectionName o nome da coleção
	 * @param pName o nome
	 * @return counter o número de documentos deletados
	 */
	public long delete(String pCollectionName, String pName) {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name", pName);
		DeleteResult result = getCollection(pCollectionName).deleteMany(searchQuery);
		return result.getDeletedCount();
	}
	
	/**
	 * Obter a coleção.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pCollectionName o nome da coleção
	 * @return collection a coleção
	 */
	public MongoCollection<Document> getCollection(String pCollectionName) {
		return getDataBase().getCollection(pCollectionName);
	}
	
	/**
	 * Obter a base de dados.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return database a base de dados
	 */
	public MongoDatabase getDataBase() {
		MongoClient client = ConnectionFactory.getMongoClient();
		return client.getDatabase(Api.DATA_BASE.getValue());
	}
	
	/**
	 * Encontrar os documentos.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pCollectionName o nome da coleção
	 * @return documents os documentos
	 */
	public List<Document> find(String pCollectionName) {
		FindIterable<Document> cursor = getCollection(pCollectionName).find();
		List<Document> documents = new ArrayList<Document>();
		
		for (Document document : cursor) {
			documents.add(document);
		}
		return documents;
	}
	
	/**
	 * Encontrar o documento.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pCollectionName o nome da coleção
	 * @param pId o id
	 * @return document o documento
	 */
	public Document find(String pCollectionName, ObjectId pId) {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("_id", pId);
		FindIterable<Document> cursor = getCollection(pCollectionName).find(searchQuery);
		return cursor.first();
	}
	
	/**
	 * Encontrar o documento.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pCollectionName o nome da coleção
	 * @param pName o nome
	 * @return document o documento
	 */
	public Document find(String pCollectionName, String pName) {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name", pName);
		FindIterable<Document> cursor = getCollection(pCollectionName).find(searchQuery);
		return cursor.first();
	}
	
	/**
	 * Inserir o documento.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pCollectionName o nome da coleção
	 * @param pDocument o documento
	 */
	public void insert(String pCollectionName, Document pDocument) {
		MongoCollection<Document> collection = getDataBase().getCollection(pCollectionName);
		collection.insertOne(pDocument);
	}
	
	/**
	 * Atualizar o documento.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pCollectionName o nome da coleção
	 * @param pId o id
	 * @param pDocument o documento
	 * @return counter o número de documentos atualizados
	 */
	public long update(String pCollectionName, ObjectId pId, String pKey, double pValue) {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("_id", pId);
		BasicDBObject updateQuery = new BasicDBObject();
		updateQuery.put(pKey, pValue);
		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", updateQuery);
		UpdateResult result = getCollection(pCollectionName).updateMany(searchQuery, updateObject);
		return result.getModifiedCount();
	}
	
	/**
	 * Atualizar o documento.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pCollectionName o nome da coleção
	 * @param pName o nome
	 * @param pDocument o documento
	 * @return counter o número de documentos atualizados
	 */
	public long update(String pCollectionName, String pName, String pKey, double pValue) {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name", pName);
		BasicDBObject updateQuery = new BasicDBObject();
		updateQuery.put(pKey, pValue);
		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", updateQuery);
		UpdateResult result = getCollection(pCollectionName).updateMany(searchQuery, updateObject);
		return result.getModifiedCount();
	}
	
	/**
	 * Atualizar o documento.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pCollectionName o nome da coleção
	 * @param pId o id
	 * @param pDocument o documento
	 * @return counter o número de documentos atualizados
	 */
	public long update(String pCollectionName, ObjectId pId, String pKey, String pValue) {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("_id", pId);
		BasicDBObject updateQuery = new BasicDBObject();
		updateQuery.put(pKey, pValue);
		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", updateQuery);
		UpdateResult result = getCollection(pCollectionName).updateMany(searchQuery, updateObject);
		return result.getModifiedCount();
	}
	
	/**
	 * Atualizar o documento.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pCollectionName o nome da coleção
	 * @param pName o nome
	 * @param pDocument o documento
	 * @return counter o número de documentos atualizados
	 */
	public long update(String pCollectionName, String pName, String pKey, String pValue) {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name", pName);
		BasicDBObject updateQuery = new BasicDBObject();
		updateQuery.put(pKey, pValue);
		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", updateQuery);
		UpdateResult result = getCollection(pCollectionName).updateMany(searchQuery, updateObject);
		return result.getModifiedCount();
	}
}

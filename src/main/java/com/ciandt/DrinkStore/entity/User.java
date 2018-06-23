package com.ciandt.DrinkStore.entity;

import java.util.Date;

import org.bson.Document;

public class User extends Entity {
	private Date date;
	
	/**
	 * Construtor da classe.
	 * @author Gugatb
	 * @date 13/05/2018
	 */
	public User() {
		this.date = new Date();
	}
	
	/**
	 * Construtor da classe.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pDocument o documento
	 */
	public User(Document pDocument) {
		this.set(pDocument);
	}
	
	/**
	 * Obter o documento.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return document o documento
	 */
	public Document get() {
		Document document = new Document();
		document.put("date", getDate());
		document.put("name", getName());
		return document;
	}
	
	/**
	 * Obter a data.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return date a data
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * Definir o documento.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pDocument o documento
	 */
	public void set(Document pDocument) {
		this.setDate(pDocument.getDate("date"));
		this.setId(pDocument.getObjectId("_id").toString());
		this.setName(pDocument.getString("name"));
	}
	
	/**
	 * Obter o volume.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pDate a data
	 */
	public void setDate(Date pDate) {
		this.date = pDate;
	}
}

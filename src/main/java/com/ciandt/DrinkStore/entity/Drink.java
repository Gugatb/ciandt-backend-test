package com.ciandt.DrinkStore.entity;

import java.util.Date;

import org.bson.Document;

public class Drink extends Entity {
	private Date date;
	private Double price;
	private String type;
	
	/**
	 * Construtor da classe.
	 * @author Gugatb
	 * @date 13/05/2018
	 */
	public Drink() {
		this.date = new Date();
		this.price = 0.0;
		this.type = "";
	}
	
	/**
	 * Construtor da classe.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pDocument o documento
	 */
	public Drink(Document pDocument) {
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
		document.put("price", getPrice());
		document.put("type", getType());
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
	 * Obter o preço.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return price o preço
	 */
	public Double getPrice() {
		return price;
	}
	
	/**
	 * Obter o tipo.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return type o tipo
	 */
	public String getType() {
		return type;
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
		this.setPrice(pDocument.getDouble("price"));
		this.setType(pDocument.getString("type"));
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
	
	/**
	 * Definir o preço.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pPrice o preço
	 */
	public void setPrice(Double pPrice) {
		this.price = pPrice;
	}
	
	/**
	 * Definir o tipo.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pType o tipo
	 */
	public void setType(String pType) {
		this.type = pType;
	}
}

package com.ciandt.DrinkStore.entity;

import java.util.Date;

import org.bson.Document;

public class DrinkType extends Entity {
	private Date date;
	private Double capacity; 
	
	/**
	 * Construtor da classe.
	 * @author Gugatb
	 * @date 13/05/2018
	 */
	public DrinkType() {
		this.date = new Date();
		this.capacity = 0.0;
	}
	
	/**
	 * Construtor da classe.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pDocument o documento
	 */
	public DrinkType(Document pDocument) {
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
		document.put("capacity", getCapacity());
		document.put("date", getDate());
		document.put("name", getName());
		return document;
	}
	
	/**
	 * Obter a capacidade.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return capacity a capacidade
	 */
	public Double getCapacity() {
		return capacity;
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
		this.setCapacity(pDocument.getDouble("capacity"));
		this.setDate(pDocument.getDate("date"));
		this.setId(pDocument.getObjectId("_id").toString());
		this.setName(pDocument.getString("name"));
	}
	
	/**
	 * Definir a capaciade.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pCapacity a capacidade
	 */
	public void setCapacity(Double pCapacity) {
		this.capacity = pCapacity;
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

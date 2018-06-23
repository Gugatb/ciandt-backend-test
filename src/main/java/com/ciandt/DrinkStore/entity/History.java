package com.ciandt.DrinkStore.entity;

import java.util.Date;

import org.bson.Document;

public class History extends Entity {
	private Date date;
	private String drink;
	private String drinkType;
	private String section;
	private String type;
	private String user;
	private Double volume;
	
	/**
	 * Construtor da classe.
	 * @author Gugatb
	 * @date 13/05/2018
	 */
	public History() {
		this.date = new Date();
		this.drink = "";
		this.drinkType = "";
		this.section = "";
		this.type = "";
		this.user = "";
		this.volume = 0.0;
	}
	
	/**
	 * Construtor da classe.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pDocument o documento
	 */
	public History(Document pDocument) {
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
		document.put("drink", getDrink());
		document.put("drink_type", getDrinkType());
		document.put("name", getName());
		document.put("section", getSection());
		document.put("type", getType());
		document.put("user", getUser());
		document.put("volume", getVolume());
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
	 * Obter a bebida.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return drink a bebida
	 */
	public String getDrink() {
		return drink;
	}
	
	/**
	 * Obter o tipo de bebida.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return drinkType o tipo de bebida
	 */
	public String getDrinkType() {
		return drinkType;
	}
	
	/**
	 * Obter a seção.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return section a seção
	 */
	public String getSection() {
		return section;
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
	 * Obter o usuário.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return user o usuário
	 */
	public String getUser() {
		return user;
	}
	
	/**
	 * Obter o volume.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return volume o volume
	 */
	public Double getVolume() {
		return volume;
	}
	
	/**
	 * Definir o documento.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pDocument o documento
	 */
	public void set(Document pDocument) {
		this.setDate(pDocument.getDate("date"));
		this.setDrink(pDocument.getString("drink"));
		this.setDrinkType(pDocument.getString("drink_type"));
		this.setId(pDocument.getObjectId("_id").toString());
		this.setName(pDocument.getString("name"));
		this.setSection(pDocument.getString("section"));
		this.setType(pDocument.getString("type"));
		this.setUser(pDocument.getString("user"));
		this.setVolume(pDocument.getDouble("volume"));
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
	 * Definir a bebida.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return pDrink a bebida
	 */
	public void setDrink(String pDrink) {
		this.drink = pDrink;
	}
	
	/**
	 * Definir o tipo de bebida.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return pDrinkType o tipo de bebida
	 */
	public void setDrinkType(String pDrinkType) {
		this.drinkType = pDrinkType;
	}
	
	/**
	 * Definir o nome.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pDrink a bebida
	 * @param pDrinkType o tipo de bebida
	 * @param pSection a seção
	 */
	public void setName(Drink pDrink, DrinkType pDrinkType, Section pSection) {
		setName(pDrink.getId() + "; " + pDrinkType.getId() + "; " + pSection.getId());
	}
	
	/**
	 * Definir a seção.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return pSection a seção
	 */
	public void setSection(String pSection) {
		this.section = pSection;
	}
	
	/**
	 * Definir o tipo.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return type o tipo
	 */
	public void setType(String pType) {
		this.type = pType;
	}
	
	/**
	 * Definir o usuário.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pUser o usuário
	 */
	public void setUser(String pUser) {
		this.user = pUser;
	}
	
	/**
	 * Definir o volume.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pVolume o volume
	 */
	public void setVolume(Double pVolume) {
		this.volume = pVolume;
	}
}

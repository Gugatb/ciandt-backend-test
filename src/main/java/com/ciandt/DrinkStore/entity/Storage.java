package com.ciandt.DrinkStore.entity;

import org.bson.Document;

public class Storage extends Entity {
	private String drink;
	private String drinkType;
	private String section;
	private Double volume;
	
	/**
	 * Construtor da classe.
	 * @author Gugatb
	 * @date 13/05/2018
	 */
	public Storage() {
		this.drink = "";
		this.drinkType = "";
		this.section = "";
		this.volume = 0.0;
	}
	
	/**
	 * Construtor da classe.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pDocument o documento
	 */
	public Storage(Document pDocument) {
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
		document.put("drink", getDrink());
		document.put("drink_type", getDrinkType());
		document.put("name", getName());
		document.put("section", getSection());
		document.put("volume", getVolume());
		return document;
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
		this.setDrink(pDocument.getString("drink"));
		this.setDrinkType(pDocument.getString("drink_type"));
		this.setId(pDocument.getObjectId("_id").toString());
		this.setName(pDocument.getString("name"));
		this.setSection(pDocument.getString("section"));
		this.setVolume(pDocument.getDouble("volume"));
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
	 * Definir o volume.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pVolume o volume
	 */
	public void setVolume(Double pVolume) {
		this.volume = pVolume;
	}
}

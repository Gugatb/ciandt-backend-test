package com.ciandt.DrinkStore.entity;

public class Entity {
	private String id;
	private String name;
	
	/**
	 * Construtor da classe.
	 * @author Gugatb
	 * @date 13/05/2018
	 */
	public Entity() {
		this.id = "";
		this.name = "";
	}
	
	/**
	 * Obter o id.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return id o id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Obter o nome.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return name o nome
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Definir o id.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pId o id
	 */
	public void setId(String pId) {
		this.id = pId;
	}
	
	/**
	 * Definir o nome.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pName o nome
	 */
	public void setName(String pName) {
		this.name = pName;
	}
}

package com.ciandt.DrinkStore.constant;

public enum Collection {
	DRINK("DRINK", "drink"),
	DRINK_TYPE("DRINK_TYPE", "drink_type"),
	HISTORY("HISTORY", "history"),
	SECTION("SECTION", "section"),
	STORAGE("STORAGE", "storage"),
	USER("USER", "user");
	
	// Valor padrão.
	public final static Collection DEFAULT = DRINK_TYPE;
	
	private String name;
	private String value;
	
	/**
	 * Contrutor da classe.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pName o nome
	 * @param pValue o valor
	 */
	Collection(String pName, String pValue) {
		this.name = pName;
		this.value = pValue;
	}
	
	/**
	 * Verificar se contém o valor.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pValue o valor
	 * @return true se contém, caso contrário false
	 */
	public boolean contains(String pValue) {
		boolean contains = false;
		
		for (Collection item : Collection.values()) {
			if (item.getValue().equals(pValue)) {
				contains = true;
			}
		}
		return contains;
	}
	
	/**
	 * Obter a constante.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pName o nome
	 * @return constant a constante
	 */
	public Collection getConstant(String pName) {
		Collection constant = null;
		
		for (Collection item : Collection.values()) {
			if (item.getName().equals(pName)) {
				constant = item;
			}
		}
		return constant;
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
	 * Obter o valor.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return value o valor
	 */
	public String getValue() {
		return value;
	}
}

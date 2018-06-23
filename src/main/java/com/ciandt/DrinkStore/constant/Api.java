package com.ciandt.DrinkStore.constant;

public enum Api {
	DATA_BASE("DATA_BASE", "drink_store");
	
	// Valor padrão.
	public final static Api DEFAULT = DATA_BASE;
	
	private String name;
	private String value;
	
	/**
	 * Contrutor da classe.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pName o nome
	 * @param pValue o valor
	 */
	Api(String pName, String pValue) {
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
		
		for (Api item : Api.values()) {
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
	public Api getConstant(String pName) {
		Api constant = null;
		
		for (Api item : Api.values()) {
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

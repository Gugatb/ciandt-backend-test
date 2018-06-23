package com.ciandt.DrinkStore.exception;

public class DrinkTypeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 4239256907011093097L;
	
	/**
	 * Construtor da classe.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pText o texto
	 */
	public DrinkTypeNotFoundException(String pText) {
		super(pText);
	}
}

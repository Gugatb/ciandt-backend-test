package com.ciandt.DrinkStore.constant;

public enum Message {
	ALREADY_NAME_EXISTING("ALREADY_NAME_EXISTING", "Nome informado ja existente"),
	BAD_REQUEST("BAD_REQUEST", "Requisicao invalida"),
	DRINK_NOT_FOUND("DRINK_NOT_FOUND", "Bebida nao encontrada"),
	DRINK_TYPE_NOT_FOUND("DRINK_TYPE_NOT_FOUND", "Tipo de bebida nao encontrado"),
	INVALID_DRINK_TYPE("INVALID_DRINK_TYPE", "Tipo de bebida inválido"),
	INSUFFICIENT_INVENTORY("INSUFFICIENT_INVENTORY", "Estoque insuficiente"),
	INVALID_REQUEST_FORMAT("INVALID_REQUEST_FORMAT", "Formato da requisicao invalido"),
	NAME_NOT_FOUND("NAME_NOT_FOUND", "Nome nao encontrado"),
	SECTION_NOT_FOUND("SECTION_NOT_FOUND", "Secao nao encontrada"),
	UNAVAILABLE("UNAVAILABLE", "Servico indisponivel"),
	USER_NOT_FOUND("USER_NOT_FOUND", "Usuario nao encontrado");
	
	// Valor padrão.
	public final static Message DEFAULT = UNAVAILABLE;
	
	private String name;
	private String value;
	
	/**
	 * Contrutor da classe.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pName o nome
	 * @param pValue o valor
	 */
	Message(String pName, String pValue) {
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
		
		for (Message item : Message.values()) {
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
	public Message getConstant(String pName) {
		Message constant = null;
		
		for (Message item : Message.values()) {
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

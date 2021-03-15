package com.joaogcm.api.geek.burguer.entities.enums;

public enum TypeClient {

	PHYSICALPERSON(1, "Physical Person"), LEGALPERSON(2, "Legal Person");

	private Integer statusClient;
	private String descriptionClient;

	private TypeClient() {

	}

	private TypeClient(Integer statusClient, String descriptionClient) {
		this.statusClient = statusClient;
		this.descriptionClient = descriptionClient;
	}

	public Integer getStatusClient() {
		return statusClient;
	}

	public void setStatusClient(Integer statusClient) {
		this.statusClient = statusClient;
	}

	public String getDescriptionClient() {
		return descriptionClient;
	}

	public void setDescriptionClient(String descriptionClient) {
		this.descriptionClient = descriptionClient;
	}

	public static TypeClient status(Integer code) {
		if (code == null) {
			return null;
		}

		for (TypeClient type : TypeClient.values()) {
			if (code.equals(type.getStatusClient())) {
				return type;
			}
		}

		throw new IllegalArgumentException("Código inválido: ID = " + code);
	}
}
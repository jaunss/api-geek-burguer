package com.joaogcm.api.geek.burguer.resources.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nameField;
	private String messageField;

	public FieldMessage() {

	}

	public FieldMessage(String nameField, String messageField) {
		this.nameField = nameField;
		this.messageField = messageField;
	}

	public String getNameField() {
		return nameField;
	}

	public void setNameField(String nameField) {
		this.nameField = nameField;
	}

	public String getMessageField() {
		return messageField;
	}

	public void setMessageField(String messageField) {
		this.messageField = messageField;
	}
}
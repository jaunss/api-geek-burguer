package com.joaogcm.api.geek.burguer.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> fields = new ArrayList<FieldMessage>();
	
	public ValidationError() {
		
	}
	
	public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}
	
	public List<FieldMessage> getFields() {
		return fields;
	}
	
	public void addErrorsFields(String nameField, String messageField) {
		fields.add(new FieldMessage(nameField, messageField));
	}
}
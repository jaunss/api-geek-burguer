package com.joaogcm.api.geek.burguer.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.joaogcm.api.geek.burguer.services.exceptions.DataIntegrityException;
import com.joaogcm.api.geek.burguer.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		String error = "Não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;

		StandardError standard = new StandardError(System.currentTimeMillis(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(standard);
	}

	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {
		String error = "Integridade de dados encontrada";
		HttpStatus status = HttpStatus.BAD_REQUEST;

		StandardError standard = new StandardError(System.currentTimeMillis(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(standard);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
		String error = "Erro de validação";
		HttpStatus status = HttpStatus.BAD_REQUEST;

		ValidationError validation = new ValidationError(System.currentTimeMillis(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		
		for (FieldError field : e.getBindingResult().getFieldErrors()) {
			validation.addErrorsFields(field.getField(), field.getDefaultMessage());;
		}
		
		return ResponseEntity.status(status).body(validation);
	}
}
package com.demo.springboot.rest.exception;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class StudentIDNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long errorCode;
	private String errorMessage;
	
	public StudentIDNotFoundException(String errorMessage, Long errorCode) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public StudentIDNotFoundException() {
		
	}

}

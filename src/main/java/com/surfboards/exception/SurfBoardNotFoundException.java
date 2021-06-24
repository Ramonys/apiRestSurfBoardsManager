package com.surfboards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SurfBoardNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SurfBoardNotFoundException( Long id) {
		super("Pesron not found with ID: " + id );

	}


	
}


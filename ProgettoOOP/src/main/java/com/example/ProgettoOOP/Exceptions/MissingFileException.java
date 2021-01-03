package com.example.ProgettoOOP.Exceptions;

import java.io.IOException;

public class MissingFileException extends IOException{

	private static final long serialVersionUID = 1L;
	public MissingFileException() {
		super();
	}

	public MissingFileException(String message) {
		super(message);
	}
}

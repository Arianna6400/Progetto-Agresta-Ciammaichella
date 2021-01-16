package com.example.ProgettoOOP.Exceptions;

import java.io.IOException;

/**Eccezione personalizzata che estende IOException,
 * che viene lanciata in caso di anomalie in input/
 * output dei file esterni 
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/io/IOException.html">IOException</a>
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class MissingFileException extends IOException{

	private static final long serialVersionUID = 1L;
	public MissingFileException() {
		super();
	}

	/**Lancia un messaggio personalizzato nel caso
	 * venga lanciata l'eccezione
	 * @param message messaggio di output dell'eccezione
	 */
	public MissingFileException(String message) {
		super(message);
	}
}

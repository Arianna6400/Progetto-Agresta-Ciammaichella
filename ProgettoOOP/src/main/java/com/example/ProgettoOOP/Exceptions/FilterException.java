package com.example.ProgettoOOP.Exceptions;

/**Eccezione personalizzata che estende Exception
 * e viene richiamata in caso di anomalie dei filtraggi
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Exception.html">Exception</a>
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class FilterException extends Exception {

	private static final long serialVersionUID = 2L;
	public FilterException() {
		super();
	}

	/**Lancia un messaggio perzonalizzato in caso
	 * venga chiamata l'eccezione
	 * @param message messaggio di output dell'eccezione 
	 */
	public FilterException(String message) {
		super(message);
	}
}

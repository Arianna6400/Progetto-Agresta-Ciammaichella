package com.example.ProgettoOOP.owapi;

/**Superclasse per i canali di collegamento con le API
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */
public class OWClass {

	protected static String APIKey = "e28976a0972295b5cf35effb838d0ba9"; //Key privata d'accesso alle API
	protected double lat;
	protected double lon;
	/**Costruttore per la chiamata tramite lat e lon
	 * @param lat 
	 * @param lon
	 */
	public OWClass(double lat, double lon) {
		this.lat=lat;
		this.lon=lon;
	}
	
}

package com.example.ProgettoOOP.owapi;


/**Superclasse per i canali di collegamento con le API
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */
public class OWClass {

	protected static String APIKey ; //Key privata d'accesso alle API
	protected double lat;
	protected double lon;
	/**Costruttore per la chiamata tramite lat e lon
	 * @param lat latitudine
	 * @param lon longitudine
	 */
	public OWClass(double lat, double lon)  {
		this.lat=lat;
		this.lon=lon;
	}
	
}

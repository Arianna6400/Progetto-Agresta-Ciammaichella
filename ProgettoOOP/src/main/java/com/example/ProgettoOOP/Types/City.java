package com.example.ProgettoOOP.Types;

/**Classe usata per immagazinare i dati 
 * provenienti dal file "Città.json"
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class City {

	public String CityName;
	public double lat;
	public double lon;
	
	public City(String CityName, double lat, double lon) {
		this.CityName=CityName;
		this.lat=lat;
		this.lon=lon;
	}
	
}

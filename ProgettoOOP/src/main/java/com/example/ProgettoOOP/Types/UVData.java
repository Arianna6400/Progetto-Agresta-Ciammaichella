package com.example.ProgettoOOP.Types;

/**Classe usata per immagazzinare dati ricevuti da OpenWeather
 * da inserire nel DataSet in "Uv.json"
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class UVData {
	public String name;
	public String date_iso;
	public long date;
	public double value;
	public UVData(String CityName,String date_iso,long data,double UV) {
		this.name=CityName;
		this.date=data;
		this.value=UV;
		this.date_iso=date_iso;
	}
	
}

package com.example.ProgettoOOP.Rate;

import java.util.Vector;
import com.example.ProgettoOOP.Types.UVData;

/**Classe che contiene il metodo per il calcolo matematico
 * del Minimo tra i valori dei raggi UV presi da OpenWeather
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class Minimo extends RateClass {

	public Minimo(String CityName, Vector<UVData> DataSet) {
		super(CityName, DataSet);
	}

	/**Metodo public che definisce il calcolo matematico del valore minimo
     * tra i valori dei raggi UV
     * @param CityName Parametro di tipo String
     * @param DataSet Un Vector di tipo UVData
     * @return Valore di tipo double del minimo 
     */
	
	public static double getMinimo(String CityName,Vector<UVData> DataSet) {
		double min = Double.POSITIVE_INFINITY;
		for(UVData d : DataSet) {
			if(d.name.equals(CityName) && d.value<min) {
				min=d.value;
			}
		}
		return min;
	}
}

package com.example.ProgettoOOP.Rate;

import java.util.Vector;
import com.example.ProgettoOOP.Types.UVData;

/**Classe che contiene il metodo per il calcolo matematico
 * della Varianza dei i valori dei raggi UV presi da OpenWeather
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class Varianza extends RateClass {

	public Varianza(String CityName, Vector<UVData> DataSet) {
		super(CityName, DataSet);
	}
	
	/**Metodo public che definisce il calcolo matematico della varianza
     * dei valori dei raggi UV
     * @param CityName Parametro di tipo String
     * @param DataSet Un Vector di tipo UVData
     * @return Valore di tipo double della varianza 
     */

	public static double getVarianza(String CityName,Vector<UVData> DataSet) {
		int counter = 0;
		double sum=0;
		double avg = Media.getMedia(CityName,DataSet);
		for(UVData d : DataSet) {
			if(d.name.equals(CityName)) {
				d.value-=avg;
				d.value*=d.value;
				sum+=d.value;
				counter++;
			}
		}
		double tot=sum/counter;
		
		return tot;
	}
}

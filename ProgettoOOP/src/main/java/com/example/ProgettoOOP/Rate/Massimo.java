package com.example.ProgettoOOP.Rate;
import java.util.Vector;
import com.example.ProgettoOOP.Types.UVData;

/**Classe che contiene il metodo per il calcolo matematico
 * del Massimo tra i valori dei raggi UV presi da OpenWeather
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class Massimo extends RateClass {

    public Massimo(String CityName, Vector<UVData> DataSet) {
		super(CityName, DataSet);
	}
    
    /**Metodo public che definisce il calcolo matematico del valore massimo
     * tra i valori dei raggi UV
     * @param CityName Parametro di tipo String
     * @param DataSet Un Vector di tipo UVData
     * @return Valore di tipo double del massimo 
     */

	public static double getMassimo(String CityName,Vector<UVData> DataSet) {
    	double max=0;
        for(UVData d : DataSet) {
            if(d.name.equals(CityName) && d.value>max) {
                max=d.value;
            }
        }
        return max;
    }
    
}
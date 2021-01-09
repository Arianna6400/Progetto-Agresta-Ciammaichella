package com.example.ProgettoOOP.Rate;
import java.util.Vector;
import com.example.ProgettoOOP.Types.UVData;

/**Classe che contiene il metodo per il calcolo matematico
 * della Media dei i valori dei raggi UV presi da OpenWeather
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class Media extends RateClass {

    public Media(String CityName, Vector<UVData> DataSet) {
		super(CityName, DataSet);
	}

    /**Metodo public che definisce il calcolo matematico della media
     * dei valori dei raggi UV
     * @param CityName Parametro di tipo String
     * @param DataSet Un Vector di tipo UVData
     * @return Valore di tipo double della media 
     */
    
	public static double getMedia(String CityName,Vector<UVData> DataSet) {
    	int counter =0;
        double sum=0, avg=0;
        for(UVData d: DataSet) {
            if(d.name.equals(CityName)) {
            	sum+=d.value;
            	counter++;
            }
        }
        avg=sum/counter;
        return avg;
    }
    
}
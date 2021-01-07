package com.example.ProgettoOOP.Rate;
import java.io.IOException;
import java.util.Vector;
import com.example.ProgettoOOP.Types.UVData;

/**
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class Massimo extends RateClass {

    public Massimo(String CityName, Vector<UVData> DataSet) {
		super(CityName, DataSet);
	}

	public static double getMassimo(String CityName,Vector<UVData> DataSet) throws IOException {
    	double max=0;
        for(UVData d : DataSet) {
            if(d.name.equals(CityName) && d.value>max) {
                max=d.value;
            }
        }
        return max;
    }
    
}
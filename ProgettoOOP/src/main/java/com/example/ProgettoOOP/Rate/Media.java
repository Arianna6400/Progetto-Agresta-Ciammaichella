package com.example.ProgettoOOP.Rate;
import java.io.IOException;
import java.util.Vector;
import com.example.ProgettoOOP.Types.UVData;

/**
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class Media extends RateClass {

    public Media(String CityName, Vector<UVData> DataSet) {
		super(CityName, DataSet);
	}

	public static double getMedia(String CityName,Vector<UVData> DataSet) throws IOException {
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
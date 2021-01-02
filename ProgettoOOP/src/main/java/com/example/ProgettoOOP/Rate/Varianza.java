package com.example.ProgettoOOP.Rate;

import java.io.IOException;
import java.util.Vector;
import com.example.ProgettoOOP.Types.UVData;

/**
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class Varianza {

	public static double getVarianza(String CityName,Vector<UVData> DataSet) throws IOException {
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

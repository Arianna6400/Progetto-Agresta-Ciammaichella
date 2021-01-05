package com.example.ProgettoOOP.Rate;

import java.io.IOException;
import java.util.Vector;
import com.example.ProgettoOOP.Types.UVData;

/**
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class Minimo extends RateClass {

	public Minimo(String CityName, Vector<UVData> DataSet) {
		super(CityName, DataSet);
	}

	public static double getMinimo(String CityName,Vector<UVData> DataSet) throws IOException {
		double min = Double.POSITIVE_INFINITY;
		for(UVData d : DataSet) {
			if(d.name.equals(CityName) && d.value<min) {
				min=d.value;
			}
		}
		return min;
	}
}

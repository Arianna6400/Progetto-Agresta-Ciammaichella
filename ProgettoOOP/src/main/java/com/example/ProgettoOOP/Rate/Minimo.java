package com.example.ProgettoOOP.Rate;

import java.io.IOException;
import java.util.Vector;

import com.example.ProgettoOOP.Types.UVData;
import com.example.ProgettoOOP.util.Reader;

public class Minimo {
	public Vector<Double> UVDataSet = new Vector<Double>();
	public Minimo(Vector<Double> UVDataSet) {
		this.UVDataSet = UVDataSet;
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

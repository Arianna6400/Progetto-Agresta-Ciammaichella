package com.example.ProgettoOOP.Rate;

import java.util.Vector;

import com.example.ProgettoOOP.Types.UVData;

public class Minimo {
	public Vector<Double> UVDataSet = new Vector<Double>();
	public Minimo(Vector<Double> UVDataSet) {
		this.UVDataSet = UVDataSet;
	}
	public static double getMinimo(Vector<UVData> UVDataSet) {
		double min = UVDataSet.firstElement().value;
		for(UVData d : UVDataSet) {
			if(d.value<min) {
				min=d.value;
			}
		}
		return min;
	}
}

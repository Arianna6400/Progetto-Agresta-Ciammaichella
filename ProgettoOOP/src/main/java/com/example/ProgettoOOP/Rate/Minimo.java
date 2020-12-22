package com.example.ProgettoOOP.Rate;

import java.util.Vector;

public class Minimo {
	public Vector<Double> UVDataSet = new Vector<Double>();
	public Minimo(Vector<Double> UVDataSet) {
		this.UVDataSet = UVDataSet;
	}
	public static double getMinimo(Vector<Double> UVDataSet) {
		double min = UVDataSet.firstElement();
		for(double d : UVDataSet) {
			if(d<min) {
				min=d;
			}
		}
		return min;
	}
}

package com.example.ProgettoOOP.Rate;

import java.util.Vector;

public class Varianza {
	public Vector<Double> UVDataSet = new Vector<Double>();
	public Varianza(Vector<Double> UVDataSet) {
		this.UVDataSet = UVDataSet;
	}
	public static double getVarianza(Vector<Double> UVDataSet) {
		double sum=0;
		double media = Media.getMedia(UVDataSet);
		for(double d : UVDataSet) {
			d-=media;
			d*=d;
			sum+=d;
		}
		double tot=sum/(UVDataSet.size());
		
		return tot;
	}
}

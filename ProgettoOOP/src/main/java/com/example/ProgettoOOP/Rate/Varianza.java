package com.example.ProgettoOOP.Rate;

import java.util.Vector;

import com.example.ProgettoOOP.Types.UVData;

public class Varianza {
	public Vector<Double> UVDataSet = new Vector<Double>();
	public Varianza(Vector<Double> UVDataSet) {
		this.UVDataSet = UVDataSet;
	}
	public static double getVarianza(Vector<UVData> UVDataSet) {
		double sum=0;
		double media = Media.getMedia(UVDataSet);
		for(UVData d : UVDataSet) {
			d.value-=media;
			d.value*=d.value;
			sum+=d.value;
		}
		double tot=sum/(UVDataSet.size());
		
		return tot;
	}
}

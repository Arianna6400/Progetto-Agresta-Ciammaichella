package com.example.ProgettoOOP.Rate;

import java.util.Vector;

import com.example.ProgettoOOP.Types.*;

public class RateClass {

	protected Vector<UVData> DataSet;
	protected String CityName;
	public RateClass(String CityName, Vector <UVData> DataSet) {
		this.CityName = CityName;
		this.DataSet= DataSet;
	}
}
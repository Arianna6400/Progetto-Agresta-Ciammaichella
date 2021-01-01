package com.example.ProgettoOOP.Rate;
import java.io.IOException;
import java.util.Vector;

import com.example.ProgettoOOP.Types.UVData;
import com.example.ProgettoOOP.util.Reader;

public class Massimo {

 

    public Vector<Double> UVDataSet = new Vector<Double>();
    public Massimo(Vector<Double> UVDataSet) {
            this.UVDataSet = UVDataSet;
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
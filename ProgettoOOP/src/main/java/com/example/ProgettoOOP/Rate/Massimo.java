package com.example.ProgettoOOP.Rate;
import java.util.Vector;

import com.example.ProgettoOOP.Types.UVData;

public class Massimo {

 

    public Vector<Double> UVDataSet = new Vector<Double>();
    public Massimo(Vector<Double> UVDataSet) {
            this.UVDataSet = UVDataSet;
    }
    public static double getMassimo(Vector<UVData> UVDataSet) {
        double max=UVDataSet.firstElement().value;
        for(UVData d : UVDataSet) {
            if(d.value>max) {
                max=d.value;
            }
        }
        return max;
    }
    
}
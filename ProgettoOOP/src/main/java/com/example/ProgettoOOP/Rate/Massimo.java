package com.example.ProgettoOOP.Rate;
import java.util.Vector;

public class Massimo {

 

    public Vector<Double> UVDataSet = new Vector<Double>();
    public Massimo(Vector<Double> UVDataSet) {
            this.UVDataSet = UVDataSet;
    }
    public static double getMassimo(Vector<Double> UVDataSet) {
        double max=UVDataSet.firstElement();
        for(double d : UVDataSet) {
            if(d>max) {
                max=d;
            }
        }
        return max;
    }
    
}
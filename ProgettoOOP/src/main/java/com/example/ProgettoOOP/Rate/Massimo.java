package com.example.ProgettoOOP.Rate;
import java.io.IOException;
import java.util.Vector;
import com.example.ProgettoOOP.Types.UVData;

public class Massimo {

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
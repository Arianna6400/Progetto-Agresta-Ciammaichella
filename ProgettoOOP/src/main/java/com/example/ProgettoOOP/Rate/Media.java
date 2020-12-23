package com.example.ProgettoOOP.Rate;
import java.util.Vector;

import com.example.ProgettoOOP.Types.UVData;
public class Media {

 

    public Vector <Double> UVDataSet= new Vector <Double>();
    public Media(Vector <Double> UVDataSet) {
        this.UVDataSet=UVDataSet;
    }
    public static double getMedia(Vector<UVData> UVDataSet) {
        double sum=0, media=0;
        for(UVData d: UVDataSet) {
            {
                sum+=d.value;
            }
            media=sum/(UVDataSet.size());
        }
        return media;
    }
    
}
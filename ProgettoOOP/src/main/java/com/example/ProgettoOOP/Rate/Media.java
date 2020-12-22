package com.example.ProgettoOOP.Rate;
import java.util.Vector;
public class Media {

 

    public Vector <Double> UVDataSet= new Vector <Double>();
    public Media(Vector <Double> UVDataSet) {
        this.UVDataSet=UVDataSet;
    }
    public static double getMedia(Vector<Double> UVDataSet) {
        double sum=0, media=0;
        for(double d: UVDataSet) {
            {
                sum+=d;
            }
            media=sum/(UVDataSet.size());
        }
        return media;
    }
    
}
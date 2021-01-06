package com.example.ProgettoOOP.util;

import java.util.Vector;
import com.example.ProgettoOOP.Types.*;
import com.example.ProgettoOOP.owapi.*;

/**
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class DataSet_Populator {
	public static void sleep() throws Exception {
	
		Vector<City> CityData = Reader.getVectorCity(); 
		for(City c: CityData) {
			if(c.lat<-90.0||c.lat>90.0) 
				  throw new IllegalArgumentException("Invalid latitude given in" + c.CityName);
		    if(c.lon<-180.0||c.lon>180.0) 
		    	  throw new IllegalArgumentException("Invalid longitude given in" + c.CityName);
		}
		Vector<UVData> DataSet = Reader.getVectorUV();
		while(true) {
			for(int i=0;i<CityData.size();i++) {
				DataSet.add(getUV.call(CityData.get(i).lat,CityData.get(i).lon));
			}
			Writer.populate(DataSet);
			Thread.sleep(1000*60*60);
		}
	}
}
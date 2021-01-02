package com.example.ProgettoOOP.util;

import java.util.Vector;
import com.example.ProgettoOOP.Types.*;
import com.example.ProgettoOOP.owapi.getUV;

/**
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class DataSet_Populator {
	public static void sleep() throws Exception {
	
		Vector<City> CityData = Reader.getVectorCity(); 
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
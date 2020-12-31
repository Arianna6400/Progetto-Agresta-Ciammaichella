package com.example.ProgettoOOP.util;

import java.util.Vector;
import com.example.ProgettoOOP.Types.*;

public class DataSet_Populator {
	public static void sleep() throws Exception {
	
		Vector<City> CityData = Reader.getVectorCity(); 
		
		while(true) {
			for(int i=0;i<CityData.size();i++) {
				Writer.populate(CityData.get(i).lat, CityData.get(i).lon);
			}
			Thread.sleep(1000*60*60);
		}
	}
}
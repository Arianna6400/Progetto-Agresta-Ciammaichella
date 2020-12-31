package com.example.ProgettoOOP.test;

import java.util.Vector;
import com.example.ProgettoOOP.Types.*;
import com.example.ProgettoOOP.util.*;

public class test_sleep {
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
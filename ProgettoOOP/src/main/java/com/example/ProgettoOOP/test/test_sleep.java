package com.example.ProgettoOOP.test;

import java.util.Vector;

import com.example.ProgettoOOP.util.Writer;

public class test_sleep {
	public static void sleep() throws Exception {
		Vector<Double> lats = new Vector<Double>();
		Vector<Double> lons = new Vector<Double>();
		Double latPes=42.460239;
		Double lonPes=14.21021;
		Double latAn=43.59816;
		Double lonAn=13.51008;
		Double latRm=41.894741;
		Double lonRm=12.4839;
		Double latMi=45.464272;
		Double lonMi=9.18951;
		Double latVe=45.43861;
		Double lonVe=12.32667;
		lats.add(latPes);
		lats.add(latAn);
		lats.add(latRm);
		lats.add(latMi);
		lats.add(latVe);
		lons.add(lonPes);
		lons.add(lonAn);
		lons.add(lonRm);
		lons.add(lonMi);
		lons.add(lonVe);
		
		while(true) {
			for(int i=0;i<5;i++) {
				Writer.populate(lats.get(i),lons.get(i));
			}
			Thread.sleep(1000*60*60);
		}
	}
}
package com.example.ProgettoOOP.util;

import java.io.IOException;
import java.util.Vector;
import com.example.ProgettoOOP.Types.*;
import com.google.gson.Gson;

public class StatsParser {
	public static Vector<UVData> getBody(String test) throws IOException {
		boolean flag= false;
		Gson gson = new Gson();
		BodyStats body = gson.fromJson(test, BodyStats.class);
		Vector<UVData> DataSet= Reader.getVectorUV();
		Vector<UVData> toRemove=new Vector<UVData>();
		if(!body.Cities.isEmpty()) {
			for(UVData d : DataSet) {
				for(String name : body.Cities) {
					if(d.name.equals(name)) {
						flag=true;
					}
				}
				if(!flag) {
					toRemove.add(d);
				}
				flag=false;
			}
		}
		DataSet.removeAll(toRemove);
		toRemove.clear();
		if(!body.Range.isEmpty()) {
			Vector<Long> Range = Time.getRange(DataSet, body.Range);
			for(UVData d : DataSet) {
				if(d.date>Range.firstElement() || d.date<Range.lastElement()) {
					toRemove.add(d);
				}
			}
		}
		DataSet.removeAll(toRemove);
		toRemove.clear();
		//aggiungere max,min,media e var dopo aver cambiato la lettura delle città
		return DataSet;
	}
	
}

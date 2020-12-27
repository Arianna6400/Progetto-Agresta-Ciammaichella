package com.example.ProgettoOOP.util;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import com.example.ProgettoOOP.Types.*;
import com.google.gson.Gson;

public class BodyParser {
	public static Vector<UVData> getBody(String test) throws IOException {
		Vector<UVData> FilteredVector = new Vector<UVData>();
		Gson gson = new Gson();
		Body body = gson.fromJson(test, Body.class);
		Vector<UVData> DataSet= Reader.getVectorFile();
		if (body.Cities.isEmpty()) {
			FilteredVector =  DataSet;
		}
		else {
			for(UVData d : DataSet) {
				for(String name : body.Cities) {
					if(d.name.equals(name)) {
						FilteredVector.add(d);
					}
				}
			}
		}
		
		
		return FilteredVector;
	}
	
}

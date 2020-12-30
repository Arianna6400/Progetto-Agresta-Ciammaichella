package com.example.ProgettoOOP.util;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import com.example.ProgettoOOP.Types.*;
import com.google.gson.Gson;

public class DataParser {
	public static Vector<UVData> getBody(String test) throws IOException {
		boolean flag= false;
		Gson gson = new Gson();
		BodyData body = gson.fromJson(test, BodyData.class);
		Vector<UVData> DataSet= Reader.getVectorFile();
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
		if(body.Value != null) {
			if(body.Value.Greater != 0) {
				for(UVData d: DataSet) {
					if(d.value<body.Value.Greater) {
						toRemove.add(d);
					}
				}
			}
			else if(body.Value.Less != 0) {
				for(UVData d: DataSet) {
					if(d.value>body.Value.Less) {
						toRemove.add(d);
					}
				}
			}
			else if(!body.Value.Included.isEmpty()) {
				for(UVData d: DataSet) {
					if(d.value<body.Value.Included.firstElement() || d.value>body.Value.Included.lastElement()) {
						toRemove.add(d);
					}
				}
			}
			else if(!body.Value.NotIncluded.isEmpty()) {
				for(UVData d: DataSet) {
					if(d.value>body.Value.NotIncluded.firstElement() && d.value<body.Value.NotIncluded.lastElement()) {
						toRemove.add(d);
					}
				}
			}
		}
		DataSet.removeAll(toRemove);
		toRemove.clear();
		return DataSet;
	}
	
}

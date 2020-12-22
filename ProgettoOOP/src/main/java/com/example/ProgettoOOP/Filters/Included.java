package com.example.ProgettoOOP.Filters;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import com.example.ProgettoOOP.Types.UVData;
import com.example.ProgettoOOP.util.Reader;
import com.google.gson.Gson;

public class Included {
	public static List<UVData> getIncluded (List<UVData> DataSet,double min,double max) throws IOException {
		List<UVData> fin = new Vector<UVData>();
		for(UVData d : DataSet) {
			if(d.value>min && d.value<max) {
				fin.add(d);
			}
		}
		return fin;
	}
}

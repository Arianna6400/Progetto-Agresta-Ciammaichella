package com.example.ProgettoOOP.Filters;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import com.example.ProgettoOOP.Types.UVData;
import com.example.ProgettoOOP.util.Reader;
import com.google.gson.Gson;

public class GreaterThan {
	public static List<UVData> getGreater (List<UVData> DataSet,double num) throws IOException {
		List<UVData> fin = new Vector<UVData>();
		for(UVData d : DataSet) {
			if(d.value>num) {
				fin.add(d);
			}
		}
		return fin;
	}
}

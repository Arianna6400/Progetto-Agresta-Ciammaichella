package com.example.ProgettoOOP.Filters;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import com.example.ProgettoOOP.Types.UVData;
import com.example.ProgettoOOP.util.Reader;
import com.google.gson.Gson;

public class LessThan {
	public static String getLess (double num) throws IOException {
		Vector<UVData> fin = new Vector<UVData>();
		List<UVData> data = Reader.getVectorFile();
		for(UVData d : data) {
			if(d.value<num) {
				fin.add(d);
			}
		}
		Gson gson= new Gson();
		String filteredJson = gson.toJson(fin);
		return filteredJson;
	}
}

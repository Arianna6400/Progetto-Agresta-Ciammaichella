package com.example.ProgettoOOP.Filters;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import com.example.ProgettoOOP.Types.UVData;

public class GreaterThan {

	public static List<UVData> getGreater (double num, List<UVData> dataset) throws IOException {
		List<UVData> fin = new Vector<UVData>();
		for(UVData d : dataset) {
			if(d.value>num) {
				fin.add(d);
			}
		}
		return fin;
	}
}

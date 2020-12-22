package com.example.ProgettoOOP.Filters;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import com.example.ProgettoOOP.Types.UVData;

public class LessThan {
	public static List<UVData> getLess (List<UVData> DataSet, double num) throws IOException {
		List<UVData> fin = new Vector<UVData>();
		for(UVData d : DataSet) {
			if(d.value<num) {
				fin.add(d);
			}
		}
		return fin;
	}
}

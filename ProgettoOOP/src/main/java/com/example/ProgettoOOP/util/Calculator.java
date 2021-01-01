package com.example.ProgettoOOP.util;

import java.io.IOException;
import java.util.Vector;
import com.example.ProgettoOOP.Types.UVData;
public class Calculator {
	public static Vector<String> ListParser(Vector<UVData> DataSet) throws IOException {
		boolean flag= false;
		Vector<String> CityNames = new Vector<String>();
		CityNames.add(DataSet.firstElement().name);
		for(UVData d : DataSet) {
			for(String s : CityNames) {
				if(d.name.equals(s)) {
					flag = true;
				}
			}
			if(flag == false) {
				CityNames.add(d.name);
			}
			flag=false;
		}
		return CityNames;
	}
}

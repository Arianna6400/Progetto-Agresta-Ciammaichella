package com.example.ProgettoOOP.util;

import java.io.IOException;
import java.util.Vector;
import com.example.ProgettoOOP.Types.UVData;
public class Calculator {
	public static Vector<String> ListParser() throws IOException {
		Vector<UVData> DataList = Reader.getVectorUV();
		boolean flag= false;
		Vector<String> CityNames = new Vector<String>();
		CityNames.add(DataList.firstElement().name);
		for(UVData d : DataList) {
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

package com.example.ProgettoOOP.util;

import java.io.IOException;
import java.util.Vector;
import com.example.ProgettoOOP.Filters.*;
import com.example.ProgettoOOP.Types.*;
import com.google.gson.Gson;

public class DataParser {
	public static String getBody(String Filters) throws IOException {
		Gson gson = new Gson();
		BodyData body = gson.fromJson(Filters, BodyData.class);
		Vector<UVData> DataSet= Reader.getVectorUV();
		DataSet=CitiesFilter.getCityFilter(body,DataSet);
		DataSet=RangeFilter.getRangeFilter(body, DataSet);
		DataSet=ValueFilter.getValueFilter(body, DataSet);
        String DataSetJson = gson.toJson(DataSet);
		return DataSetJson;
	}
	
}

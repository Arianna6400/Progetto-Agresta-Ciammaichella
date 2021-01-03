package com.example.ProgettoOOP.util;

import java.io.IOException;
import java.util.Vector;

import com.example.ProgettoOOP.Exceptions.FilterException;
import com.example.ProgettoOOP.Filters.*;
import com.example.ProgettoOOP.Types.*;
import com.google.gson.Gson;

/**
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class DataParser {
	public static String getBody(String Filters) throws IOException, FilterException {
		if(Filters.contains("cities")) {
			Filters=Filters.replace("cities", "Cities");
		}
		if(Filters.contains("range")) {
			Filters=Filters.replace("range", "Range");
		}
		if(Filters.contains("value")) {
			Filters=Filters.replace("value", "Value");
		}
		if(Filters.contains("greater")) {
			Filters=Filters.replace("greater", "Greater");
		}
		if(Filters.contains("less")) {
			Filters=Filters.replace("less", "Less");
		}
		if(Filters.contains("included")) {
			Filters=Filters.replace("included", "Included");
		}
		if(Filters.contains("notincluded")) {
			Filters=Filters.replace("notincluded", "NotIncluded");
		}
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

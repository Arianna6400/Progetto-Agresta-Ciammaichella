package com.example.ProgettoOOP.util;

import java.io.IOException;
import java.util.Vector;

import com.example.ProgettoOOP.Exceptions.FilterException;
import com.example.ProgettoOOP.Filters.AvgFilter;
import com.example.ProgettoOOP.Filters.CitiesFilter;
import com.example.ProgettoOOP.Filters.MaxFilter;
import com.example.ProgettoOOP.Filters.MinFilter;
import com.example.ProgettoOOP.Filters.RangeFilter;
import com.example.ProgettoOOP.Filters.VarFilter;
import com.example.ProgettoOOP.Rate.Massimo;
import com.example.ProgettoOOP.Rate.Media;
import com.example.ProgettoOOP.Rate.Minimo;
import com.example.ProgettoOOP.Rate.Varianza;
import com.example.ProgettoOOP.Types.*;
import com.google.gson.Gson;

/**
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class StatsParser {
	public static String getBody(String Filters) throws IOException, FilterException {
		if(Filters.contains("cities")) {
			Filters=Filters.replace("cities", "Cities");
		}
		if(Filters.contains("range")) {
			Filters=Filters.replace("range", "Range");
		}
		if(Filters.contains("max")) {
			Filters=Filters.replace("max", "Max");
		}
		if(Filters.contains("min")) {
			Filters=Filters.replace("min", "Min");
		}
		if(Filters.contains("avg")) {
			Filters=Filters.replace("avg", "Avg");
		}
		if(Filters.contains("var")) {
			Filters=Filters.replace("var", "Var");
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
		BodyStats body = gson.fromJson(Filters, BodyStats.class);
		Vector<UVData> DataSet= Reader.getVectorUV();
		DataSet=CitiesFilter.getCityFilter(body,DataSet);
		DataSet=RangeFilter.getRangeFilter(body, DataSet); 
		Vector<String> CitiesNames=Calculator.ListParser(DataSet);
		Vector<Result> Stats = new Vector<Result>();
		for(String s : CitiesNames) { 
			Result result = new Result();
			result.Max=Massimo.getMassimo(s,DataSet);
			result.Min=Minimo.getMinimo(s,DataSet);
			result.Avg=Media.getMedia(s,DataSet);
			result.Var=Varianza.getVarianza(s,DataSet);
			result.CityName=s;
			Stats.add(result);
		}
		Stats=MaxFilter.getMaxFilter(body, Stats);
		Stats=MinFilter.getMinFilter(body, Stats);
		Stats=AvgFilter.getAvgFilter(body, Stats);
		Stats=VarFilter.getVarFilter(body, Stats);
		String StatsJson = gson.toJson(Stats);
		return StatsJson;
	}
	
}

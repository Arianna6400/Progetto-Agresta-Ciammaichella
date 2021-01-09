package com.example.ProgettoOOP.util;

import java.io.IOException;
import java.util.Vector;

import com.example.ProgettoOOP.Exceptions.FilterException;
import com.example.ProgettoOOP.Filters.*;
import com.example.ProgettoOOP.Rate.*;
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
		boolean flag = false;
		Vector<Result> Stats = new Vector<Result>();
		BodyStats body = gson.fromJson(Filters, BodyStats.class);
		Vector<UVData> DataSet= Reader.getVectorUV();
		DataSet=CitiesFilter.getCityFilter(body,DataSet);
		Vector<String> CitiesNames=Calculator.ListParser(DataSet);
		int start = 0;
		int stop= body.Range-1;
		while(!flag) {
			Vector<UVData> DataSetBackup = new Vector<UVData>(DataSet);
			DataSetBackup=RangeFilter.getRangeFilter(body,start,stop,DataSet);
			if(DataSetBackup.isEmpty()) {
				flag=true;
				break;
			}
				for(String s : CitiesNames) { 
					Result result = new Result();
					result.Max=Massimo.getMassimo(s,DataSetBackup);
					result.Min=Minimo.getMinimo(s,DataSetBackup);
					result.Avg=Media.getMedia(s,DataSetBackup);
					result.Var=Varianza.getVarianza(s,DataSetBackup);
					result.CityName=s;
					Stats.add(result);
				}
				start+=body.Range;
				stop+=body.Range;
				DataSetBackup.clear();
			}
		
			Stats=MaxFilter.getMaxFilter(body, Stats);
			Stats=MinFilter.getMinFilter(body, Stats);
			Stats=AvgFilter.getAvgFilter(body, Stats);
			Stats=VarFilter.getVarFilter(body, Stats);
			String StatsJson = gson.toJson(Stats);
			return StatsJson;
		
	}
	
}

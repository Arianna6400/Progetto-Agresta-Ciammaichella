package com.example.ProgettoOOP.util;

import java.io.IOException;
import java.util.Vector;
import com.example.ProgettoOOP.Rate.*;
import com.example.ProgettoOOP.Types.*;
import com.google.gson.Gson;

public class DataCity {
	public static String getResult (Vector<String> CitiesName) throws IOException  {
		Gson gson = new Gson();
		Vector<Result> Stats = new Vector<Result>();
		Vector<UVData> DataSet = Reader.getVectorUV();
		for(String s : CitiesName) { 
			Result result = new Result();
			result.Max=Massimo.getMassimo(s,DataSet);
			result.Min=Minimo.getMinimo(s,DataSet);
			result.Avg=Media.getMedia(s,DataSet);
			result.Var=Varianza.getVarianza(s,DataSet);
			result.CityName=s;
			Stats.add(result);
		}
		String strJson = gson.toJson(Stats);
		return strJson ;
	}
}

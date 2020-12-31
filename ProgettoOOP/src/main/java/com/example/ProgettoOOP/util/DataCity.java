package com.example.ProgettoOOP.util;

import java.io.IOException;
import java.util.Vector;
import com.example.ProgettoOOP.Rate.Massimo;
import com.example.ProgettoOOP.Rate.Media;
import com.example.ProgettoOOP.Rate.Minimo;
import com.example.ProgettoOOP.Rate.Varianza;
import com.example.ProgettoOOP.Types.Result;
import com.google.gson.Gson;

public class DataCity {
	public static String getResult (Vector<String> CitiesName) throws IOException  {
		Gson gson = new Gson();
		Vector<Result> Stats = new Vector<Result>();
		for(String s : CitiesName) { 
			Result result = new Result();
			result.Max=Massimo.getMassimo(s);
			result.Min=Minimo.getMinimo(s);
			result.Avg=Media.getMedia(s);
			result.Var=Varianza.getVarianza(s);
			result.CityName=s;
			Stats.add(result);
		}
		String strJson = gson.toJson(Stats);
		return strJson ;
	}
}

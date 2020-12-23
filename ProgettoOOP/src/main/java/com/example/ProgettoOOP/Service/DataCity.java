package com.example.ProgettoOOP.Service;

import java.util.Vector;

import com.example.ProgettoOOP.Rate.Massimo;
import com.example.ProgettoOOP.Rate.Media;
import com.example.ProgettoOOP.Rate.Minimo;
import com.example.ProgettoOOP.Rate.Varianza;
import com.example.ProgettoOOP.Types.Result;
import com.example.ProgettoOOP.Types.UVData;
import com.example.ProgettoOOP.util.Time;

public class DataCity {
	public static Result getResult (Vector<UVData> City)  {
		Result result = new Result(); 
		result.Max=Massimo.getMassimo(City);
		result.Min=Minimo.getMinimo(City);
		result.Avg=Media.getMedia(City);
		result.Var=Varianza.getVarianza(City);
		result.CityName=City.firstElement().name;
		return result;
	}
}

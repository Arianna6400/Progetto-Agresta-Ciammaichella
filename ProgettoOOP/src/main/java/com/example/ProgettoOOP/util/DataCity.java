package com.example.ProgettoOOP.util;

import java.io.IOException;
import java.util.Vector;
import com.example.ProgettoOOP.Rate.*;
import com.example.ProgettoOOP.Types.*;
import com.google.gson.Gson;

/**Classe che gestisce la chiamata /stats di tipo GET
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class DataCity {
	
	/**Funzione che calcola le statistiche per ogni città 
	 * all'interno dell'intero dataset
	 * @param CitiesName Vector di stringhe contenente tutte le città presenti nel dataset
	 * @return una stringa in json contenente un Vector di result popolato da ogni città con le rispettive statistiche
	 */
	
	public static String getResult (Vector<String> CitiesName) {
		Gson gson = new Gson();
		Vector<Result> Stats = new Vector<Result>();
		Vector<UVData> DataSet;
		try {
		      DataSet = Reader.getVectorUV();
		      for(String s : CitiesName) { 
			           Result result = new Result();
			           result.Max=Massimo.getMassimo(s,DataSet);
			           result.Min=Minimo.getMinimo(s,DataSet);
			           result.Avg=Media.getMedia(s,DataSet);
			           result.Var=Varianza.getVarianza(s,DataSet);
			           result.CityName=s;
			           Stats.add(result);
		     }
		} catch (IOException e) { 
			e.printStackTrace();
			}
		String strJson = gson.toJson(Stats);
		return strJson ;
	}
}

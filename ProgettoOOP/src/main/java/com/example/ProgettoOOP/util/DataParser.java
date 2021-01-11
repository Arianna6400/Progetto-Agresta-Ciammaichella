package com.example.ProgettoOOP.util;

import java.io.IOException;
import java.util.Vector;

import com.example.ProgettoOOP.Exceptions.FilterException;
import com.example.ProgettoOOP.Filters.*;
import com.example.ProgettoOOP.Types.*;
import com.google.gson.Gson;

/**Classe che modifica il dataset in base ai filtri inseriti
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class DataParser {
	
	/**Funzione che elimina dal dataset totale ogni ogetto json che non 
	 * rispetta i filtri inseriti dall'utente
	 * @param Filters stringa contenente i filtri da applicare al dataset
	 * @return stringa in json contenente il dataset filrato
	 * @throws IOException se si verifica un problema di Input/Output 
	 * @throws FilterException se si verifica un problema con i filtri inseriti 
	 */
	
	public static String getBody(String Filters) throws IOException, FilterException {
		//if a cascata che rendono "non-case sensitive" l'inserimento dei filtri
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

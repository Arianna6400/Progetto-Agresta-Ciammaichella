package com.example.ProgettoOOP.util;

import java.io.IOException;
import java.util.Vector;

import com.example.ProgettoOOP.Exceptions.FilterException;
import com.example.ProgettoOOP.Filters.*;
import com.example.ProgettoOOP.Rate.*;
import com.example.ProgettoOOP.Types.*;
import com.google.gson.Gson;

/**Classe che modifica il dataset a seconda dei filtri inseriti e 
 * calcola le statistiche (anche'esse filtrate) su di esso
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class StatsParser {
	/**Funzione che elimina dal dataset totale ogni ogetto json che non 
	 * rispetta i filtri inseriti dall'utente,successivamente calcola i filtri su di esso
	 * filtrando anch'essi se richiesto
	 * @param Filters stringa in json contenente i filtri inseriti dall'utente
	 * @return stringa in json che rappresenta un vector di Result contenente le statistiche filtrate per ogni città
	 * @throws IOException  se si verifica un problema di Input/Output
	 * @throws FilterException se si verifica un errore di input dei filtri da parte dell'utente
	 */
	public static String getBody(String Filters) throws IOException, FilterException {
		//if a cascata che rendono "non-case sensitive" l'inserimento dei filtri
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
		boolean flag = false;//variabile booleana utilizzata per capire quando uscire dal ciclo 
		Vector<Result> Stats = new Vector<Result>();
		BodyStats body = gson.fromJson(Filters, BodyStats.class);
		Vector<UVData> DataSet= Reader.getVectorUV();
		DataSet=CitiesFilter.getCityFilter(body,DataSet);
		Vector<String> CitiesNames=Calculator.ListParser(DataSet);
		int start = 0;                 //inizializzo i due interi che utilizzerò come range da passare alla funzione Time.getRange
		int stop= body.Range-1;
		while(!flag && body.Range!= 0) {           //entro nel ciclo che gira tutto il dataset solo se l'utente inserisce il filtro "range"
			Vector<UVData> DataSetBackup = new Vector<UVData>(DataSet);
			DataSetBackup=RangeFilter.getRangeFilter(body,start,stop,DataSet);
			if(DataSetBackup.isEmpty()) {               //se DataSetBackup è vuoto significa che ho girato tutto il dataset originale e posso fermarmi
				flag=true;                          
				break;
			}
				for(String s : CitiesNames) {                //questo ciclo calcola le ststs per ogni città all'interno del dataset filtrato 
					Result result = new Result();
					result.Max=Massimo.getMassimo(s,DataSetBackup);
					result.Min=Minimo.getMinimo(s,DataSetBackup);
					result.Avg=Media.getMedia(s,DataSetBackup);
					result.Var=Varianza.getVarianza(s,DataSetBackup);
					result.CityName=s;
					Stats.add(result);
				}
				start+=body.Range;                            //eseguo l'update delle variabili start e stop per avere il range successivo nella iterazione 
				stop+=body.Range;                             //il range successivo nella iterazione successiva
				DataSetBackup.clear();
			}
		if(body.Range==0) {                                 //entro qui solo se l'utente non ha inserito il filtro "range"
			for(String s : CitiesNames) { 
				Result result = new Result();
				result.Max=Massimo.getMassimo(s,DataSet);
				result.Min=Minimo.getMinimo(s,DataSet);
				result.Avg=Media.getMedia(s,DataSet);
				result.Var=Varianza.getVarianza(s,DataSet);
				result.CityName=s;
				Stats.add(result);
			}
		}
		Stats=MaxFilter.getMaxFilter(body, Stats);                  //infine applico il filtraggio delle statistiche se richiesto
		Stats=MinFilter.getMinFilter(body, Stats);
		Stats=AvgFilter.getAvgFilter(body, Stats);
		Stats=VarFilter.getVarFilter(body, Stats);
		String StatsJson = gson.toJson(Stats);
		return StatsJson;
		
	}
	
}

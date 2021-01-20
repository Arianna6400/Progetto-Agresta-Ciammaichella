package com.example.ProgettoOOP.Filters;

import java.util.Vector;

import com.example.ProgettoOOP.Exceptions.*;
import com.example.ProgettoOOP.Types.*;

/**Classe di visibilità public che contiene il metodo
 * getValueFilter per il filtraggio del valore dei raggi UV
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class ValueFilter {
	
	/**Metodo public per il filtro del Valore UV che popola un 
	 * Vector di elementi da rimuovere dal filtraggio
	 * @param body Parametro di tipo BodyData
	 * @param DataSet Un Vector di tipo UVData
	 * @return Un Vector di UVData con filtraggio applicato
	 * @throws FilterException In caso di errori in input da parte dell'utente
	 */
	
	public static Vector<UVData> getValueFilter (BodyData body,Vector<UVData> DataSet) throws FilterException{
		Vector<UVData> toRemove=new Vector<UVData>(); //Vettore da popolare e poi da rimuovere
		if(body.Value != null) {
			if(body.Value.Greater != 0) {
				for(UVData d: DataSet) {
					if(d.value<body.Value.Greater) {
						toRemove.add(d);
					}
				}
			}
			else if(body.Value.Less != 0) {
				for(UVData d: DataSet) {
					if(d.value>body.Value.Less) {
						toRemove.add(d);
					}
				}
			}
			else if(body.Value.Included != null) {
				if(body.Value.Included.size()!=2) {
					throw new FilterException("Illegal number of inputs");
				}
				for(UVData d: DataSet) {
					if(d.value<body.Value.Included.firstElement() || d.value>body.Value.Included.lastElement()) {
						toRemove.add(d);
					}
				}
			}
			else if(body.Value.NotIncluded != null) {
				if(body.Value.NotIncluded.size()!=2) {
					throw new FilterException("Illegal number of inputs");
				}
				for(UVData d: DataSet) {
					if(d.value>body.Value.NotIncluded.firstElement() && d.value<body.Value.NotIncluded.lastElement()) {
						toRemove.add(d);
					}
				}
			}
		}
		DataSet.removeAll(toRemove); //Popola il Vector di Result StatsSet filtrato
		toRemove.clear(); //Pulisce il primo Vector popolato
		return DataSet;
	}
}

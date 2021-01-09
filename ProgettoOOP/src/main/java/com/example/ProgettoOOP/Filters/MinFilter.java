package com.example.ProgettoOOP.Filters;

import java.util.Vector;

import com.example.ProgettoOOP.Exceptions.FilterException;
import com.example.ProgettoOOP.Types.BodyStats;
import com.example.ProgettoOOP.Types.Result;

/**Classe di visibilità public che contiene il metodo
 * getMinFilter per il filtraggio del minimo
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class MinFilter {
	
	/**Metodo public per il filtro Minimo che popola un Vector di
	 * elementi da rimuovere dal filtraggio
	 * @param body Parametro di tipo BodyStats
	 * @param StatsSet Un Vector di tipo Result
	 * @return Un Vector di Result con filtraggio applicato
	 * @throws FilterException In caso di errori in input da parte dell'utente
	 */
	
	public static Vector<Result> getMinFilter (BodyStats body,Vector<Result> StatsSet) throws FilterException{
		Vector<Result> toRemove=new Vector<Result>(); //Vettore da popolare e poi da rimuovere
		if(body.Min != null) {
			if(body.Min.Greater != 0) {
				for(Result d: StatsSet) {
					if(d.Min<body.Min.Greater) {
						toRemove.add(d);
					}
				}
			}
			else if(body.Min.Less != 0) {
				for(Result d: StatsSet) {
					if(d.Min>body.Min.Less) {
						toRemove.add(d);
					}
				}
			}
			else if(!body.Min.Included.isEmpty()) {
				if(body.Min.Included.size()!=2) {
					throw new FilterException("Illegal number of inputs");
				}
				for(Result d: StatsSet) {
					if(d.Min<body.Min.Included.firstElement() || d.Min>body.Min.Included.lastElement()) {
						toRemove.add(d);
					}
				}
			}
			else if(!body.Min.NotIncluded.isEmpty()) {
				if(body.Min.NotIncluded.size()!=2) {
					throw new FilterException("Illegal number of inputs");
				}
				for(Result d: StatsSet) {
					if(d.Min>body.Min.NotIncluded.firstElement() && d.Min<body.Min.NotIncluded.lastElement()) {
						toRemove.add(d);
					}
				}
			}
			StatsSet.removeAll(toRemove); //Popola il Vector di Result StatsSet filtrato
		}
		return StatsSet;
	}
}

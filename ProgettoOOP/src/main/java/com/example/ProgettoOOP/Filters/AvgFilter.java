package com.example.ProgettoOOP.Filters;

import java.util.Vector;

import com.example.ProgettoOOP.Exceptions.FilterException;
import com.example.ProgettoOOP.Types.*;

/**Classe di visibilità public che contiene il metodo
 * getAvgFilter per il filtraggio della media
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class AvgFilter {
	
	/**Metodo public per il filtro Media che popola un Vector di
	 * elementi da rimuovere dal filtraggio
	 * @param body Parametro di tipo BodyStats
	 * @param StatsSet Un Vector di tipo Result
	 * @return Un Vector di Result con filtraggio applicato
	 * @throws FilterException In caso di errori in input da parte dell'utente
	 */
	
	public static Vector<Result> getAvgFilter (BodyStats body,Vector<Result> StatsSet) throws FilterException{
		Vector<Result> toRemove=new Vector<Result>(); //Vettore da popolare e poi da rimuovere
		if(body.Avg != null) {
			if(body.Avg.Greater != 0) {
				for(Result d: StatsSet) {
					if(d.Avg<body.Avg.Greater) {
						toRemove.add(d);
					}
				}
			}
			else if(body.Avg.Less != 0) {
				for(Result d: StatsSet) {
					if(d.Avg>body.Avg.Less) {
						toRemove.add(d);
					}
				}
			}
			else if(!body.Avg.Included.isEmpty()) {
				if(body.Avg.Included.size()!=2) {
					throw new FilterException("Illegal number of inputs");
				}
				for(Result d: StatsSet) {
					if(d.Avg<body.Avg.Included.firstElement() || d.Avg>body.Avg.Included.lastElement()) {
						toRemove.add(d);
					}
				}
			}
			else if(!body.Avg.NotIncluded.isEmpty()) {
				if(body.Avg.NotIncluded.size()!=2) {
					throw new FilterException("Illegal number of inputs");
				}
				for(Result d: StatsSet) {
					if(d.Avg>body.Avg.NotIncluded.firstElement() && d.Avg<body.Avg.NotIncluded.lastElement()) {
						toRemove.add(d);
					}
				}
			}
			StatsSet.removeAll(toRemove); //Popola il Vector di Result StatsSet filtrato 
		}
		return StatsSet;
	}
}

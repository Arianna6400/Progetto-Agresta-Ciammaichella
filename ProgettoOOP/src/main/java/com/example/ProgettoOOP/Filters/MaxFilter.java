package com.example.ProgettoOOP.Filters;

import java.util.Vector;

import com.example.ProgettoOOP.Exceptions.FilterException;
import com.example.ProgettoOOP.Types.*;

/**Classe di visibilità public che contiene il metodo
 * getMaxFilter per il filtraggio del massimo
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class MaxFilter {
	
	/**Metodo public per il filtro Massimo che popola un Vector di
	 * elementi da rimuovere dal filtraggio
	 * @param body Parametro di tipo BodyStats
	 * @param StatsSet Un Vector di tipo Result
	 * @return Un Vector di Result con filtraggio applicato
	 * @throws FilterException In caso di errori in input da parte dell'utente
	 */
	
	public static Vector<Result> getMaxFilter (BodyStats body,Vector<Result> StatsSet) throws FilterException{
		Vector<Result> toRemove=new Vector<Result>(); //Vettore da popolare e poi da rimuovere
		if(body.Max != null) {
			if(body.Max.Greater != 0) {
				for(Result d: StatsSet) {
					if(d.Max<body.Max.Greater) {
						toRemove.add(d);
					}
				}
			}
			else if(body.Max.Less != 0) {
				for(Result d: StatsSet) {
					if(d.Max>body.Max.Less) {
						toRemove.add(d);
					}
				}
			}
			else if(body.Max.Included != null) {
				if(body.Max.Included.size()!=2) {
					throw new FilterException("Illegal number of inputs");
				}
				for(Result d: StatsSet) {
					if(d.Max<body.Max.Included.firstElement() || d.Max>body.Max.Included.lastElement()) {
						toRemove.add(d);
					}
				}
			}
			else if(body.Max.NotIncluded != null) {
				if(body.Max.NotIncluded.size()!=2) {
					throw new FilterException("Illegal number of inputs");
				}
				for(Result d: StatsSet) {
					if(d.Max>body.Max.NotIncluded.firstElement() && d.Max<body.Max.NotIncluded.lastElement()) {
						toRemove.add(d);
					}
				}
			}
			StatsSet.removeAll(toRemove); //Popola il Vector di Result StatsSet filtrato
		}
		return StatsSet;
	}
}

package com.example.ProgettoOOP.Filters;

import java.util.Vector;

import com.example.ProgettoOOP.Exceptions.FilterException;
import com.example.ProgettoOOP.Types.*;

/**Classe di visibilità public che contiene il metodo
 * getVarFilter per il filtraggio della varianza
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class VarFilter {
	
	/**Metodo public per il filtro Varianza che popola un Vector di
	 * elementi da rimuovere dal filtraggio
	 * @param body Parametro di tipo BodyStats
	 * @param StatsSet Un Vector di tipo Result
	 * @return Un Vector di Result con filtraggio applicato
	 * @throws FilterException In caso di errori in input da parte dell'utente
	 */	
	public static Vector<Result> getVarFilter (BodyStats body,Vector<Result> StatsSet) throws FilterException{
		Vector<Result> toRemove=new Vector<Result>();
		if(body.Var != null) {
			if(body.Var.Greater != 0) {
				for(Result d: StatsSet) {
					if(d.Var<body.Var.Greater) {
						toRemove.add(d);
					}
				}
			}
			else if(body.Var.Less != 0) {
				for(Result d: StatsSet) {
					if(d.Var>body.Var.Less) {
						toRemove.add(d);
					}
				}
			}
			else if(!body.Var.Included.isEmpty()) {
				if(body.Var.Included.size()!=2) {
					throw new FilterException("Illegal number of inputs");
				}
				for(Result d: StatsSet) {
					if(d.Var<body.Var.Included.firstElement() || d.Var>body.Var.Included.lastElement()) {
						toRemove.add(d);
					}
				}
			}
			else if(!body.Var.NotIncluded.isEmpty()) {
				if(body.Var.NotIncluded.size()!=2) {
					throw new FilterException("Illegal number of inputs");
				}
				for(Result d: StatsSet) {
					if(d.Var>body.Var.NotIncluded.firstElement() && d.Var<body.Var.NotIncluded.lastElement()) {
						toRemove.add(d);
					}
				}
			}
			StatsSet.removeAll(toRemove);
		}
		return StatsSet;
	}
}

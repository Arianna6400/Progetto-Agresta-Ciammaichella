package com.example.ProgettoOOP.util;

import java.util.Vector;

import com.example.ProgettoOOP.Types.UVData;

/**Classe che trasforma due interi, che rappresentano un numero di giorni, in date UNIX
 * a partire dall'ultimo elemento di un dataset
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class Time {
	
	/**Funzione che calcola due date in UNIX a partire da 
	 * due interi (che rappresentano un range di giorni)
	 * e l'ultima data presente nel dataset
	 * @param FilteredVector il dataset filtrato da cui trovare la data più recente
	 * @param inizio intero che rappresenta il giorno da cui partire 
	 * @param fine intero che rappresenta il giorno a cui arrivare
	 * @return un vector di long contenente due date in UNIX (il range di giorni inserito dall'utente,trasformate in UNIX)
	 */
	public static Vector<Long> getRange(Vector<UVData> FilteredVector,int inizio,int fine) {
		long start=(FilteredVector.lastElement().date)-(24*60*60*inizio);
		long stop=(FilteredVector.lastElement().date)-(24*60*60*fine);
		Vector<Long> FilteredRange = new Vector<Long>();
		FilteredRange.add(start);
		FilteredRange.add(stop);
		return FilteredRange;
	}
	
}

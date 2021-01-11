package com.example.ProgettoOOP.Filters;

import java.util.Vector;

import com.example.ProgettoOOP.Exceptions.*;
import com.example.ProgettoOOP.Types.*;
import com.example.ProgettoOOP.util.Time;

/**Classe di visibilità public che contiene il metodo
 * getRangeFilter(in overloading) per il filtraggio del range temporale
 * per il POST/data e per il POST/stats
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class RangeFilter {
	
	/***Metodo public del filtro di range temporale applicabile dall'utente per il 
	 * filtraggio dei dati, che popola un Vector di elementi da 
	 * rimuovere dal filtraggio.
	 * @param body Parametro di tipo BodyData
	 * @param DataSet Vector di tipo UVData
	 * @return Un Vector di UVData filtrato
	 * @throws FilterException In caso di errori in input da parte dell'utente
	 */
	
	public static Vector<UVData> getRangeFilter (BodyData body,Vector<UVData> DataSet) throws FilterException{
		Vector<UVData> toRemove=new Vector<UVData>(); //Vettore da popolare e poi da rimuovere
		if(!body.Range.isEmpty()) {
			if(body.Range.size()!= 2 ) {
				throw new FilterException("Illegal range input");
			}
			Vector<Long> Range = Time.getRange(DataSet, body.Range.get(0) , body.Range.get(1));
			for(UVData d : DataSet) {
				if(d.date>Range.firstElement() || d.date<Range.lastElement()) {
					toRemove.add(d);
				}
			}
		}
		DataSet.removeAll(toRemove); //Popola il Vector di UVData DataSet filtrato
		toRemove.clear(); //Pulisce il primo Vector popolato
		return DataSet;
	}
	
	/**Metodo public del filtro di range temporale applicabile dall'utente per il 
	 * filtraggio delle statistiche, che popola un Vector di elementi da 
	 * rimuovere dal filtraggio.
	 * @param body Parametro di tipo BodyStats
	 * @param inizio Parametro di tipo intero che indica l'inizio del range temporale
	 * @param fine Parametro di tipo intero che indica la fine del range temporale
	 * @param DataSet Un Vector di tipo UVData 
	 * @return Un Vector di UVData filtrato 
	 */
	
	public static Vector<UVData> getRangeFilter (BodyStats body,int inizio,int fine,Vector<UVData> DataSet) {
		Vector<UVData> toRemove=new Vector<UVData>(); //Vettore da popolare e poi da rimuovere
		Vector<UVData> DataSetHelp=new Vector<UVData>(DataSet); //Vettore di copia d'appoggio
		if(body.Range!=0) {
			Vector<Long> Range = Time.getRange(DataSetHelp,inizio,fine);
			for(UVData d : DataSetHelp) {
				if(d.date>Range.firstElement() || d.date<Range.lastElement()) {
					toRemove.add(d); 
				}
			}
		}
		DataSetHelp.removeAll(toRemove); //Popola il Vector di UVData d'appoggio filtrato
		toRemove.clear();  //Pulisce il primo Vector popolato
		return DataSetHelp;
	}
}


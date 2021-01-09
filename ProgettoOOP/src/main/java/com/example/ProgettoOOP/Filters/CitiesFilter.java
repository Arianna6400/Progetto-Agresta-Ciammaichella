package com.example.ProgettoOOP.Filters;

import java.util.Vector;
import com.example.ProgettoOOP.Types.*;

/**Classe di visibilità public che contiene i metodi
 * getCityFilter(in overloading) per il filtraggio delle città per il
 * POST/data e per il POST/stats
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class CitiesFilter {
	
	/**Metodo public del filtro città applicabile dall'utente per il 
	 * filtraggio dei dati, che popola un Vector di elementi da 
	 * rimuovere dal filtraggio.
	 * @param body Parametro di tipo BodyData
	 * @param DataSet Vector di tipo UVData
	 * @return Un Vector di UVData filtrato 
	 */
	
	public static Vector<UVData> getCityFilter (BodyData body,Vector<UVData> DataSet){
		boolean flag= false;
		Vector<UVData> toRemove=new Vector<UVData>(); //Vettore da popolare e poi da rimuovere
		if(!body.Cities.isEmpty()) {
			for(UVData d : DataSet) {
				for(String name : body.Cities) {
					if(d.name.equals(name)) {
						flag=true;
					}
				}
				if(!flag) {
					toRemove.add(d);
				}
				flag=false;
			}
		}
		DataSet.removeAll(toRemove); //Popola il Vector di UVData DataSet filtrato
		toRemove.clear(); //Pulisce il primo Vector popolato
		return DataSet;
	}
	
	/**Metodo public del filtro città applicabile dall'utente per il 
	 * filtraggio delle statistiche, che popola un Vector di elementi da 
	 * rimuovere dal filtraggio.
	 * @param body Parametro di tipo BodyStats
	 * @param DataSet Vector di tipo UVData
	 * @return Un Vector di tipo UVData filtrato
	 */
	
	public static Vector<UVData> getCityFilter (BodyStats body,Vector<UVData> DataSet){
		boolean flag= false;
		Vector<UVData> toRemove=new Vector<UVData>(); //Vettore da popolare e poi da rimuovere
		if(!body.Cities.isEmpty()) {
			for(UVData d : DataSet) {
				for(String name : body.Cities) {
					if(d.name.equals(name)) {
						flag=true;
					}
				}
				if(!flag) {
					toRemove.add(d);
				}
				flag=false;
			}
		}
		DataSet.removeAll(toRemove); //Popola il Vector di UVData DataSet filtrato
		toRemove.clear(); //Pulisce il primo Vector popolato
		return DataSet;
	}
}

package com.example.ProgettoOOP.util;

import java.util.Vector;
import com.example.ProgettoOOP.Types.UVData;

/**Classe che immagazina in un vector
 * ogni città trovata all'interno del dataset
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */
public class Calculator {
	
	/**Funzione che scorre l'intero dataset e immagazina ogni 
	 * nuovo "name" trovato in un vector
	 * @param DataSet il dataset (totale o filtrato) su cui la funzione lavora
	 * @return Un vector di stringhe contenente ogni nome di città trovato nel dataset (in singola copia)
	 */
	
	public static Vector<String> ListParser(Vector<UVData> DataSet)  {
		boolean flag= false;
		Vector<String> CityNames = new Vector<String>();
		CityNames.add(DataSet.firstElement().name);
		for(UVData d : DataSet) {
			for(String s : CityNames) {
				if(d.name.equals(s)) {
					flag = true;
				}
			}
			if(flag == false) {
				CityNames.add(d.name);
			}
			flag=false;
		}
		return CityNames;
	}
}

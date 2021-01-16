package com.example.ProgettoOOP.util;

import java.io.IOException;
import java.util.Vector;
import com.example.ProgettoOOP.Types.*;
import com.example.ProgettoOOP.owapi.*;

/**Classe che popola il dataset ogni ora con i dati ricevuti dalle api di OpenWeather
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class DataSet_Populator {
	/**Funzione che legge le città iniserite dall'utente in "Città.json"
	 * e popola il dataset ("uv.json") con dati riguardanti i raggi uv ogni ora
	 * @throws IOException se si verifica un problema di Input/Output
	 */
	public static void sleep() throws IOException{
		try {
			Vector<City> CityData = Reader.getVectorCity(); 
			for(City c: CityData) {
				if(c.lat<-90.0||c.lat>90.0) 
					throw new IllegalArgumentException("Invalid latitude given in" + c.CityName);
				if(c.lon<-180.0||c.lon>180.0) 
					throw new IllegalArgumentException("Invalid longitude given in" + c.CityName);
			}
			Vector<UVData> DataSet = Reader.getVectorUV();
			while(true) {
				for(int i=0;i<CityData.size();i++) {
					DataSet.add(getUV.call(CityData.get(i).lat,CityData.get(i).lon));
				}
				Writer.populate(DataSet);
				Thread.sleep(1000*60*60);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
package com.example.ProgettoOOP.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Vector;
import com.example.ProgettoOOP.Types.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;  

/**Classe che scrive sul dataset i nuovi dati ricevuti da OpenWeather
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class Writer {
	/**Funzione che scrive all'interno del file "uv.json" i dati 
	 * che riceve sotto forma di vector di UVData
	 * @param DataSet vector di UVData contenente i nuovi dati appena arrivati da OpenWeather
	 */
  public static void populate(Vector<UVData> DataSet) {
    try {
	  BufferedWriter myWriter = new BufferedWriter(new FileWriter("CityUVFile/Uv.json",true));
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      String uvJson = gson.toJson(DataSet);
      new FileOutputStream("CityUVFile/Uv.json").close(); 
      myWriter.append(uvJson);
      myWriter.close();
    }catch(Exception e) {
    	e.printStackTrace();
    }
    
  }
}
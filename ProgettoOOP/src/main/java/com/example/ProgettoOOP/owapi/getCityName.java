package com.example.ProgettoOOP.owapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.example.ProgettoOOP.Types.UVData;
import com.google.gson.Gson;

/**Questa sottoclasse rappresenta il canale di collegamento
 * con le API esterne di OpenWeather
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class getCityName extends OWClass {
	
	public getCityName(double lat, double lon) {
		super(lat, lon);
	}
	
	/**Metodo che chiama il nome delle città dalle API di OpenWeather
	 * tramite latitudine e longitudine
	 * @param lat latitudine
	 * @param lon longitudine
	 * @return Stringa in JSON 
	 * @throws IOException se si verifica un problema di Input/Output
	 */
	public static String call(double lat,double lon) throws IOException {
		  StringBuilder urlToRead = new StringBuilder("http://api.openweathermap.org/data/2.5/weather");
		  urlToRead.append("?lat="+lat+"&lon="+lon+"&appid="+APIKey); 
		  StringBuilder result = new StringBuilder();
	      URL url = new URL(urlToRead.toString());
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      String line;
	      while ((line = rd.readLine()) != null) {
	         result.append(line);
	      }
	      rd.close();
	      String JsonResult = result.toString();
	      Gson gson = new Gson();
	      UVData Data = gson.fromJson(JsonResult,UVData.class);
	      return Data.name;
	}
}

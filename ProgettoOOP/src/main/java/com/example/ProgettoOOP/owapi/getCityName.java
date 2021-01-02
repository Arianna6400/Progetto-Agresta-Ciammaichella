package com.example.ProgettoOOP.owapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.example.ProgettoOOP.Types.UVData;
import com.google.gson.Gson;

/**Questa classe rappresenta il canale di collegamento
 * con le API esterne di OpenWeather
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class getCityName {
	static String APIKey= "e28976a0972295b5cf35effb838d0ba9";
	public double lat;
	public double lon;
	public getCityName(double lat,double lon) {
		this.lat=lat;
		this.lon=lon;
	}
	public static String call(double lat,double lon) throws Exception {
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

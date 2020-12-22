package com.example.ProgettoOOP.owapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.ProgettoOOP.Types.UVData;
import com.google.gson.Gson;

public class getUV {
	public double lat;
	public double lon;
	public getUV(double lat,double lon) {
		this.lat=lat;
		this.lon=lon;
	}
	public static UVData call(double lat,double lon) throws Exception {
		  StringBuilder urlToRead = new StringBuilder("http://api.openweathermap.org/data/2.5/uvi");
		  urlToRead.append("?lat="+lat+"&lon="+lon+"&appid=e28976a0972295b5cf35effb838d0ba9"); 
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
	      UVData wip = gson.fromJson(JsonResult,UVData.class);
	      wip.name=getCityName.call(lat, lon);
	      return wip;
	}
}

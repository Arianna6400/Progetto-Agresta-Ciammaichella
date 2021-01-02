package com.example.ProgettoOOP.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Vector;
import com.example.ProgettoOOP.Types.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class Reader {
	public static Vector<UVData> getVectorUV() throws IOException{
	BufferedReader reader = Files.newBufferedReader(Paths.get("uv.json"));
	Vector<UVData> DataList = new Gson().fromJson(reader, new TypeToken<Vector<UVData>>() {}.getType());
	reader.close();
	return DataList;
	}
	
	public static Vector<City> getVectorCity() throws IOException{
		BufferedReader reader = Files.newBufferedReader(Paths.get("Città.json"));
		Vector<City> DataList = new Gson().fromJson(reader, new TypeToken<Vector<City>>() {}.getType());
		reader.close();
		return DataList;
		}
}
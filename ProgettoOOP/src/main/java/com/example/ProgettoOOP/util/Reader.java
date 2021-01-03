package com.example.ProgettoOOP.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Vector;
import com.example.ProgettoOOP.Exceptions.*;
import com.example.ProgettoOOP.Types.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class Reader {
	public static Vector<UVData> getVectorUV() throws IOException{
		Vector<UVData> DataList;
		try {
			BufferedReader reader = Files.newBufferedReader(Paths.get("uv.json"));
			DataList = new Gson().fromJson(reader, new TypeToken<Vector<UVData>>() {}.getType());
			reader.close();
		}
		catch(NoSuchFileException e) {
			 e.printStackTrace();
			 throw new MissingFileException("json file not found in the folder");
		}
			return DataList;
	}
	
	public static Vector<City> getVectorCity() throws IOException{
		Vector<City> DataList;
		try {
			BufferedReader reader = Files.newBufferedReader(Paths.get("Città.json"));
			DataList = new Gson().fromJson(reader, new TypeToken<Vector<City>>() {}.getType());
			reader.close();
		}
		catch(NoSuchFileException e) {
			 e.printStackTrace();
			 throw new MissingFileException("json file not found in the folder");
		}
			return DataList;
	}
}
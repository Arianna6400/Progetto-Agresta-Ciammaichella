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

/**Classe che legge da file .json e inserisce i dati in una struttura
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class Reader {
	
	/**Funzione che legge dal file "Uv.json" e inserisce i dati in un Vector di UVData
	 * @return un Vector di UVData contenente i valori all'interno del dataset
	 * @throws IOException se si verifica un problema di Input/Output
	 */
	
	public static Vector<UVData> getVectorUV() throws IOException{
		Vector<UVData> DataSet;
		try {
			BufferedReader reader = Files.newBufferedReader(Paths.get("CityUVFile/Uv.json"));
			DataSet = new Gson().fromJson(reader, new TypeToken<Vector<UVData>>() {}.getType());
			reader.close();
		}
		catch(NoSuchFileException e) {
			 e.printStackTrace();
			 throw new MissingFileException("Json file not found in the folder");
		}
			return DataSet;
	}
	/**Funzione che legge dal file "Città.json" e inserisce i dati in un Vector di City
	 * @return un Vector di City contenente i dati riguardanti le città inseriti dall'utente
	 * @throws IOException se si verifica un problema di Input/Output
	 */
	public static Vector<City> getVectorCity() throws IOException{
		Vector<City> DataList;
		try {
			BufferedReader reader = Files.newBufferedReader(Paths.get("CityUVFile/Città.json"));
			DataList = new Gson().fromJson(reader, new TypeToken<Vector<City>>() {}.getType());
			reader.close();
		}
		catch(NoSuchFileException e) {
			 e.printStackTrace();
			 throw new MissingFileException("Json file not found in the folder");
		}
			return DataList;
	}
}
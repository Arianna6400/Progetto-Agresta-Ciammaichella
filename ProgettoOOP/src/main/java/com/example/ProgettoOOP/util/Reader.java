package com.example.ProgettoOOP.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;

import com.example.ProgettoOOP.Types.UVData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;


public class Reader {
	public static List<UVData> getVectorFile() throws IOException{
	BufferedReader reader = Files.newBufferedReader(Paths.get("uv.json"));
	List<UVData> DataList = new Gson().fromJson(reader, new TypeToken<List<UVData>>() {}.getType());
	reader.close();
	return DataList;
	}
}
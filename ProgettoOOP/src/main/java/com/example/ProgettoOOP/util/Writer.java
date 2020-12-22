package com.example.ProgettoOOP.util;

import java.io.BufferedWriter;
import java.io.FileWriter;   
import java.io.IOException;

import com.example.ProgettoOOP.Types.UVData;
import com.example.ProgettoOOP.owapi.getUV;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;  

public class Writer {
  public static void populate(double lat,double lon) throws Exception {
      BufferedWriter myWriter = new BufferedWriter(new FileWriter("uv.json",true));
      UVData help = getUV.call(lat, lon);
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      String uvJson = gson.toJson(help);
      myWriter.append(uvJson);
      myWriter.append(",");
      myWriter.append("\r\n");
      myWriter.close();
  }
}
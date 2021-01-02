package com.example.ProgettoOOP.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Vector;
import com.example.ProgettoOOP.Types.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;  

/**
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class Writer {
  public static void populate(Vector<UVData> DataSet) throws Exception {
      BufferedWriter myWriter = new BufferedWriter(new FileWriter("uv.json",true));
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      String uvJson = gson.toJson(DataSet);
      new FileOutputStream("uv.json").close(); 
      myWriter.append(uvJson);
      myWriter.close();
  }
}
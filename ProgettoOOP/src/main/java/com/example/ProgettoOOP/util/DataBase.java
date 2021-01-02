package com.example.ProgettoOOP.util;
import java.io.IOException;
import java.util.Vector;
import com.example.ProgettoOOP.Types.*;
import com.google.gson.Gson;

/**
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class DataBase {
		static Vector<MetaData> MetaDataList =new Vector<MetaData>();
		static Gson gson = new Gson();
		public static  String  getMetaData(){
			MetaDataList.add(new MetaData ("CityName","Nome della città","String"));
			MetaDataList.add(new MetaData ("Lon","Longitudine della città","String"));
			MetaDataList.add(new MetaData ("Lat","Latitudine della città","String"));
			MetaDataList.add(new MetaData ("Max","Picco massimo di raggi uv ","Double"));
			MetaDataList.add(new MetaData ("Min","Picco minimo di raggi uv","Double"));
			MetaDataList.add(new MetaData ("Avg","Media dei raggi uv","Double"));
			MetaDataList.add(new MetaData ("Var","Varianza dei raggi uv","Double"));
			String strJson = gson.toJson(MetaDataList);
			return strJson ;
		}
	
		public static String  getUVData() throws IOException {
		       
	        Vector<UVData> DataList = Reader.getVectorUV();
	        String strJson = gson.toJson(DataList);
	        return strJson;
	     }
	
}

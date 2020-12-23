package com.example.ProgettoOOP.test;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import com.example.ProgettoOOP.Types.*;
import com.example.ProgettoOOP.util.Reader;
import com.google.gson.Gson;


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
		       
	        List<UVData> DataList = Reader.getVectorFile();
	        String strJson = gson.toJson(DataList);
	        return strJson;
	     }
	
}

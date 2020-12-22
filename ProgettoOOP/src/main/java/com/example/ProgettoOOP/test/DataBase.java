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
			MetaDataList.add(new MetaData ("MaxGion","Picco massimo di raggi uv giornalieri","Double"));
			MetaDataList.add(new MetaData ("MinGion","Picco minimo di raggi uv giornalieri","Double"));
			MetaDataList.add(new MetaData ("MediaGion","Media dei raggi uv giornalieri","Double"));
			MetaDataList.add(new MetaData ("VarGion","Varianza dei raggi uv giornalieri","Double"));
			MetaDataList.add(new MetaData ("MaxSett","Picco massimo di raggi uv settimanali","Double"));
			MetaDataList.add(new MetaData ("MinSett","Picco minimo di raggi uv settimanali","Double"));
			MetaDataList.add(new MetaData ("MediaSett","Media dei raggi uv Settimanali","Double"));
			MetaDataList.add(new MetaData ("VarSett","Varianza dei raggi uv settimanali","Double"));
			MetaDataList.add(new MetaData ("MaxMens","Picco massimo di raggi uv mensili","Double"));
			MetaDataList.add(new MetaData ("MinMens","Picco minimo di raggi uv mensili","Double"));
			MetaDataList.add(new MetaData ("MediaMens","Media dei raggi uv mensili","Double"));
			MetaDataList.add(new MetaData ("VarMens","Varianza dei raggi uv mensili","Double"));
			MetaDataList.add(new MetaData ("Max5g","Picco massimo di raggi uv in un range personalizzato di 5 giorni","Double"));
			MetaDataList.add(new MetaData ("Min5g","Picco minimo di raggi uv in un range personalizzato di 5 giorni","Double"));
			MetaDataList.add(new MetaData ("Media5g","Media dei raggi uv in un range personalizzato di 5 giorni","Double"));
			MetaDataList.add(new MetaData ("Var5g","Varianza dei raggi uv in un range personalizzato di 5 giorni","Double"));
			MetaDataList.add(new MetaData ("Max10g","Picco massimo di raggi uv in un range personalizzato di 10 giorni","Double"));
			MetaDataList.add(new MetaData ("Min10g","Picco minimo di raggi uv in un range personalizzato di 10 giorni","Double"));
			MetaDataList.add(new MetaData ("Media10g","Media dei raggi uv in un range personalizzato di 10 giorni","Double"));
			MetaDataList.add(new MetaData ("Var10g","Varianza dei raggi uv in un range personalizzato di 10 giorni","Double"));
		   //nel caso aggiungere range personalizzato	
			String strJson = gson.toJson(MetaDataList);
			return strJson ;
		}
	
		public static String  getUVData() throws IOException {
		       
	        List<UVData> DataList = Reader.getVectorFile();
	        String strJson = gson.toJson(DataList);
	        return strJson;
	     }
	
}

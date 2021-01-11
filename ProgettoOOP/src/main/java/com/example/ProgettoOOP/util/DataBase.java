package com.example.ProgettoOOP.util;
import java.io.IOException;
import java.util.Vector;
import com.example.ProgettoOOP.Types.*;
import com.google.gson.Gson;

/**Classe che gestisce le chiamate GET di /data e /metadata
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class DataBase {
		private static Vector<MetaData> MetaDataList =new Vector<MetaData>();
		private static Gson gson = new Gson();
		
		/**Funzione che popola il vector di MetaData e lo trasforma in stringa json 
		 * @return una stringa json contenente il vector di MetaData popolato
		 */
		
		public static  String  getMetaData(){
			MetaDataList.add(new MetaData ("CityName","Nome della città","String"));
			MetaDataList.add(new MetaData ("Lon","Longitudine della città","String"));
			MetaDataList.add(new MetaData ("Lat","Latitudine della città","String"));
			MetaDataList.add(new MetaData ("Date_iso","Data in formato aaaa/mm/gg","String"));
			MetaDataList.add(new MetaData ("Date","Data in formato unix","Long"));
			MetaDataList.add(new MetaData ("Max","Picco massimo di raggi uv ","Double"));
			MetaDataList.add(new MetaData ("Min","Picco minimo di raggi uv","Double"));
			MetaDataList.add(new MetaData ("Avg","Media dei raggi uv","Double"));
			MetaDataList.add(new MetaData ("Var","Varianza dei raggi uv","Double"));
			String strJson = gson.toJson(MetaDataList);
			return strJson ;
		}
		
		/**Funzione che legge dal file "uv.json" e trasforma i dati in json
		 * @return stringa in json contenente l'intero dataset letto da "uv.json"
		 * @throws IOException se si verifica un problema di Input/Output nella funzione "Reader.getVectorUV()"
		 */
		
		public static String  getUVData() throws IOException {
		       
	        Vector<UVData> DataList = Reader.getVectorUV();
	        String strJson = gson.toJson(DataList);
	        return strJson;
	     }
	
}

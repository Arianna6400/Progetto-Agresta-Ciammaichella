package com.example.ProgettoOOP.Controller;

import java.io.IOException;
import java.util.Vector;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.ProgettoOOP.util.*;
import com.example.ProgettoOOP.Exceptions.FilterException;
import com.example.ProgettoOOP.Types.*;

/**Rappresenta la classe Controller che gestisce 
 * le chiamate accessibili all'utente
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

@RestController
public class Controller {

	/**Risponde alla chiamata GET /metadata
	 * @return Stringa in JSON di MetaData
	 */
	@RequestMapping(value = "metadata", method=RequestMethod.GET)
		public  String getMetadata () {
			return DataBase.getMetaData();
	}
	
	/**Risponde alla chiamata GET /data
	 * @return Stringa in JSON di UVData
	 * @throws IOException se vengono generati errori di Input/Output di lettura del file
	 */

	@RequestMapping(value = "data", method=RequestMethod.GET)
    public String  getData() throws IOException {
        return DataBase.getUVData();
    }
	/**Risponde alla chiamata GET/stats
	 * @return Stringa in JSON di Result
	 * @throws IOException se vengono generati errori di Input/Output di lettura del file
	 */
	
	@RequestMapping(value = "stats", method=RequestMethod.GET)
	public String getStats() throws IOException   {
		Vector<UVData> DataSet = Reader.getVectorUV();
		Vector<String> CitiesNames=Calculator.ListParser(DataSet);
		return DataCity.getResult(CitiesNames); 
    }
	/**Risponde alla chiamata POST/data
	 * @param Filters contiene un JSON che specifica i filtri applicati ai dati dall'utente
	 * @return Stringa in JSON di UVData
	 * @throws IOException se vengono generati errori di Input/Output di lettura del file
	 * @throws FilterException se vengono generati errori nel POST riguardanti il filtraggio
	 */
	
	@RequestMapping(value = "data", method=RequestMethod.POST)
		public String postData (@RequestBody String Filters) throws IOException, FilterException {
			return DataParser.getBody(Filters);
	}
	/**Risponde alla chiamata POST/stats
	 * @param Filters contiene un JSON che specifica i filtri applicati alle statistiche dall'utente 
	 * @return Stringa in JSON di Result
	 * @throws IOException se vengono generati errori di Input/Output di lettura del file
	 * @throws FilterException se vengono generati errori nel POST riguardanti il filtraggio
	 */
	
	@RequestMapping(value = "stats", method=RequestMethod.POST)
	public String postStats (@RequestBody String Filters) throws IOException, FilterException {
		return StatsParser.getBody(Filters);
    }

}

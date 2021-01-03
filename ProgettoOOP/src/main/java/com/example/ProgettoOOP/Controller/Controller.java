package com.example.ProgettoOOP.Controller;

import java.io.IOException;
import java.util.Vector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@GetMapping("/metadata")
		public  String getMetadata () {
			return DataBase.getMetaData();
	}
	
	/**Risponde alla chiamata GET /data
	 * @return Stringa in JSON di UVData
	 * @throws IOException se vengono generati errori di Input/Output di lettura del file
	 */

	@GetMapping("/data")
    public String  getData() throws IOException {
        return DataBase.getUVData();
    }
	/**Risponde alla chiamata GET/stats
	 * @return Stringa in JSON di Result
	 * @throws IOException se vengono generati errori di Input/Output di lettura del file
	 */
	
	@GetMapping("/stats")
	public String getStats() throws IOException   {
		Vector<UVData> DataSet = Reader.getVectorUV();
		Vector<String> CitiesNames=Calculator.ListParser(DataSet);
		return DataCity.getResult(CitiesNames); 
    }
	/**Risponde alla chiamata POST/data
	 * @param Filters contiene un JSON che specifica i filtri applicati ai dati dall'utente
	 * @return Stringa in JSON di UVData
	 * @throws IOException se vengono generati errori di Input/Output di lettura del file
	 * @throws FilterException 
	 */
	
	@PostMapping("/data")
		public String postData (@RequestBody String Filters) throws IOException, FilterException {
			return DataParser.getBody(Filters);
	}
	/**Risponde alla chiamata POST/stats
	 * @param Filters contiene un JSON che specifica i filtri applicati alle statistiche dall'utente 
	 * @return Stringa in JSON di Result
	 * @throws IOException se vengono generati errori di Input/Output di lettura del file
	 * @throws FilterException 
	 */
	
	@PostMapping("/stats")
	public String postStats (@RequestBody String Filters) throws IOException, FilterException {
		return StatsParser.getBody(Filters);
    }

}

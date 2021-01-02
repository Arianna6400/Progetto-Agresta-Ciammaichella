package com.example.ProgettoOOP.Controller;

import java.io.IOException;
import java.util.Vector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.ProgettoOOP.util.*;
import com.example.ProgettoOOP.Types.*;

@RestController
public class Controller {

	
	@GetMapping("/metadata")
		public  String getMetadata () {
			return DataBase.getMetaData();
	}

	@GetMapping("/stats")
	public String getStats() throws IOException   {
		Vector<UVData> DataSet = Reader.getVectorUV();
		Vector<String> CitiesNames=Calculator.ListParser(DataSet);
		return DataCity.getResult(CitiesNames); 
}
	@GetMapping("/data")
    public String  getData() throws IOException {
        return DataBase.getUVData();
    }
	@PostMapping("/data")
		public String postData (@RequestBody String Filters) throws IOException {
			return DataParser.getBody(Filters);
	}
	@PostMapping("/stats")
	public String postStats (@RequestBody String Filters) throws IOException {
		return StatsParser.getBody(Filters);
}

}

package com.example.ProgettoOOP.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.ProgettoOOP.test.DataBase;
import com.example.ProgettoOOP.util.BodyParser;
import com.example.ProgettoOOP.util.Reader;
import com.example.ProgettoOOP.util.Time;
import com.example.ProgettoOOP.util.Writer;
import com.example.ProgettoOOP.Rate.Varianza;
import com.example.ProgettoOOP.Service.Calculator;
import com.example.ProgettoOOP.Service.*;
import com.example.ProgettoOOP.Service.StatsCreator;
import com.example.ProgettoOOP.Types.*;
import com.example.ProgettoOOP.Types.Result;
import com.example.ProgettoOOP.Types.UVData;
import com.example.ProgettoOOP.owapi.getUV;


@RestController
public class Controller {

	
	@GetMapping("/metadata")
		public  String getMetedata () {
			return DataBase.getMetaData();
	}

	@GetMapping("/stats")
	public String getStats() throws IOException   {
		List<UVData> test = Reader.getVectorFile();	
		Calculator.ListParser(test);
		Result Pes= DataCity.getResult(Calculator.getPescara());
		Result Anc= DataCity.getResult(Calculator.getAncona());
		Result Rome= DataCity.getResult(Calculator.getRome());
		Result Milan= DataCity.getResult(Calculator.getMilan());
		Result Venice= DataCity.getResult(Calculator.getVenice());
		return StatsCreator.getStats(Pes, Anc, Milan, Rome, Venice);
}
	@GetMapping("/data")
    public String  getData() throws IOException {
        return DataBase.getUVData();
    }
	@PostMapping("/test")
		public Vector<String> test (@RequestBody String test) throws IOException {
			return BodyParser.getBody(test);
	}

}

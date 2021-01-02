package com.example.ProgettoOOP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.ProgettoOOP.util.DataSet_Populator;

@SpringBootApplication
public class ProgettoOopApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProgettoOopApplication.class, args);
		DataSet_Populator.sleep(); 
	}

}

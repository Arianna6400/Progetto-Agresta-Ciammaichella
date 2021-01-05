package com.example.ProgettoOOP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.ProgettoOOP.util.DataSet_Populator;

/**Avvia l'applicazione Spring 
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

@SpringBootApplication
public class ProgettoOopApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProgettoOopApplication.class, args);
		//DataSet_Populator.sleep(); 
	}

}

package com.example.ProgettoOOP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ProgettoOOP.util.DataSet_Populator;

/**Avvia l'applicazione Spring e popola il file JSON con i dati aggiornati 
 * all'istante tramite chiamata alle API con il metodo sleep
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

@SpringBootApplication
public class ProgettoOopApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProgettoOopApplication.class, args);
		DataSet_Populator.sleep(); 
	}

}

package com.example.ProgettoOOP.Rate;

import java.util.Vector;

import com.example.ProgettoOOP.Types.*;

/**Superclasse dei Rate 
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class RateClass {

	protected Vector<UVData> DataSet;
	protected String CityName;
	
	/**Costruttore
	 * @param CityName Di tipo String
	 * @param DataSet Vector di tipo UVData
	 */
	public RateClass(String CityName, Vector <UVData> DataSet) {
		this.CityName = CityName;
		this.DataSet= DataSet;
	}
}
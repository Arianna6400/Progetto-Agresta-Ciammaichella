package com.example.ProgettoOOP.Types;

import java.util.Vector;

/**Classe usata per leggere l' input il JSON dei 
 * filtri riguardanti il metodo POST data
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class BodyData {
	public Vector<String> Cities= new Vector<String>();
	public Vector<Integer> Range = new Vector<Integer>();
	public FilterField Value;
	
	public BodyData(Vector<String> Cities, Vector<Integer> Range, FilterField Value) {
		this.Cities= Cities;
		this.Range= Range;
		this.Value= Value;
	}
	
}

package com.example.ProgettoOOP.Types;

import java.util.Vector;

/**
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class FilterField {
	public double Greater;
	public double Less;
	public Vector<Double> Included=new Vector<Double>(2);
	public Vector<Double> NotIncluded=new Vector<Double>(2);
	
	public FilterField(double Greater, double Less, Vector<Double> Included, Vector<Double> NotIncluded) {
		this.Greater=Greater;
		this.Less=Less;
		this.Included=Included;
		this.NotIncluded=NotIncluded;
	}
}

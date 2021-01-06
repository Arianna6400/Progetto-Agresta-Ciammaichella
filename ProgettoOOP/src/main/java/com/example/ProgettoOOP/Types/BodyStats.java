package com.example.ProgettoOOP.Types;

import java.util.Vector;

/**
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class BodyStats {
	public Vector<String> Cities= new Vector<String>();
	public int Range;
	public FilterField Max;
	public FilterField Min;
	public FilterField Avg;
	public FilterField Var;
	
	public BodyStats(Vector<String> Cities, int Range, FilterField Max, FilterField Min, FilterField Avg, FilterField Var) {
		
		this.Cities=Cities;
		this.Range=Range;
		this.Max=Max;
		this.Min=Min;
		this.Avg=Avg;
		this.Var=Var;
	}
}

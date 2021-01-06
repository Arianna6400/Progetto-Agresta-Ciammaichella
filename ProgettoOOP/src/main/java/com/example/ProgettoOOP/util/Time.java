package com.example.ProgettoOOP.util;

import java.util.Vector;

import com.example.ProgettoOOP.Types.UVData;

/**
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class Time {
	public static Vector<Long> getRange(Vector<UVData> FilteredVector ,Vector<Integer> Range) {
		long start=(FilteredVector.lastElement().date)-(24*60*60*Range.firstElement());
		long stop=(FilteredVector.lastElement().date)-(24*60*60*Range.lastElement());
		Vector<Long> FilteredRange = new Vector<Long>();
		FilteredRange.add(start);
		FilteredRange.add(stop);
		return FilteredRange;
	}
	public static Vector<Long> getStatsRange(Vector<UVData> FilteredVector,int inizio,int fine) {
		long start=(FilteredVector.lastElement().date)-(24*60*60*inizio);
		long stop=(FilteredVector.lastElement().date)-(24*60*60*fine);
		Vector<Long> FilteredRange = new Vector<Long>();
		FilteredRange.add(start);
		FilteredRange.add(stop);
		return FilteredRange;
	}
	
}

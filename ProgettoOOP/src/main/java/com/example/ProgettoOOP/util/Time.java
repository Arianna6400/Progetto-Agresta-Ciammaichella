package com.example.ProgettoOOP.util;

import java.util.Vector;

import com.example.ProgettoOOP.Types.UVData;

public class Time {
	public static Vector<Long> getRange(Vector<UVData> FilteredVector ,Vector<Integer> Range) {
		long start=(FilteredVector.lastElement().date)-(24*60*60*Range.firstElement());
		long stop=(FilteredVector.lastElement().date)-(24*60*60*Range.lastElement());
		Vector<Long> FilteredRange = new Vector<Long>();
		FilteredRange.add(start);
		FilteredRange.add(stop);
		return FilteredRange;
	}
	
}

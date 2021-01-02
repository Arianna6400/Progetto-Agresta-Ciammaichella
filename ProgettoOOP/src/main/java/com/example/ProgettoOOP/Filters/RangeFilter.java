package com.example.ProgettoOOP.Filters;

import java.util.Vector;
import com.example.ProgettoOOP.Types.*;
import com.example.ProgettoOOP.util.Time;

/**
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class RangeFilter {
	public static Vector<UVData> getRangeFilter (BodyData body,Vector<UVData> DataSet){
		Vector<UVData> toRemove=new Vector<UVData>();
		if(!body.Range.isEmpty()) {
			Vector<Long> Range = Time.getRange(DataSet, body.Range);
			for(UVData d : DataSet) {
				if(d.date>Range.firstElement() || d.date<Range.lastElement()) {
					toRemove.add(d);
				}
			}
		}
		DataSet.removeAll(toRemove);
		toRemove.clear();
		return DataSet;
	}
	public static Vector<UVData> getRangeFilter (BodyStats body,Vector<UVData> DataSet){
		Vector<UVData> toRemove=new Vector<UVData>();
		if(!body.Range.isEmpty()) {
			Vector<Long> Range = Time.getRange(DataSet, body.Range);
			for(UVData d : DataSet) {
				if(d.date>Range.firstElement() || d.date<Range.lastElement()) {
					toRemove.add(d);
				}
			}
		}
		DataSet.removeAll(toRemove);
		toRemove.clear();
		return DataSet;
	}
}

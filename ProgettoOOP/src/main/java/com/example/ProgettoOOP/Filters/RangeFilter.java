package com.example.ProgettoOOP.Filters;

import java.util.Vector;

import com.example.ProgettoOOP.Exceptions.*;
import com.example.ProgettoOOP.Types.*;
import com.example.ProgettoOOP.util.Time;

/**
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class RangeFilter {
	public static Vector<UVData> getRangeFilter (BodyData body,Vector<UVData> DataSet) throws FilterException{
		Vector<UVData> toRemove=new Vector<UVData>();
		if(!body.Range.isEmpty()) {
			if(body.Range.size()!= 2 ) {
				throw new FilterException("Illegal range input");
			}
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
	public static Vector<UVData> getRangeFilter (BodyStats body,int inizio,int fine,Vector<UVData> DataSet) throws FilterException{
		Vector<UVData> toRemove=new Vector<UVData>();
		Vector<UVData> DataSetHelp=new Vector<UVData>(DataSet);
		if(body.Range!=0) {
			Vector<Long> Range = Time.getStatsRange(DataSetHelp,inizio,fine);
			for(UVData d : DataSetHelp) {
				if(d.date>Range.firstElement() || d.date<Range.lastElement()) {
					toRemove.add(d); 
				}
			}
		}
		DataSetHelp.removeAll(toRemove);
		toRemove.clear();
		return DataSetHelp;
	}
}


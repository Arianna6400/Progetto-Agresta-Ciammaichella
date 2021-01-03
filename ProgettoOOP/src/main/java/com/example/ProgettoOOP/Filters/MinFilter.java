package com.example.ProgettoOOP.Filters;

import java.util.Vector;

import com.example.ProgettoOOP.Exceptions.FilterException;
import com.example.ProgettoOOP.Types.BodyStats;
import com.example.ProgettoOOP.Types.Result;

/**
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class MinFilter {
	public static Vector<Result> getMinFilter (BodyStats body,Vector<Result> StatsSet) throws FilterException{
		Vector<Result> toRemove=new Vector<Result>();
		if(body.Min != null) {
			if(body.Min.Greater != 0) {
				for(Result d: StatsSet) {
					if(d.Min<body.Min.Greater) {
						toRemove.add(d);
					}
				}
			}
			else if(body.Min.Less != 0) {
				for(Result d: StatsSet) {
					if(d.Min>body.Min.Less) {
						toRemove.add(d);
					}
				}
			}
			else if(!body.Min.Included.isEmpty()) {
				if(body.Min.Included.size()!=2) {
					throw new FilterException("Illegal number of inputs");
				}
				for(Result d: StatsSet) {
					if(d.Min<body.Min.Included.firstElement() || d.Min>body.Min.Included.lastElement()) {
						toRemove.add(d);
					}
				}
			}
			else if(!body.Min.NotIncluded.isEmpty()) {
				if(body.Min.NotIncluded.size()!=2) {
					throw new FilterException("Illegal number of inputs");
				}
				for(Result d: StatsSet) {
					if(d.Min>body.Min.NotIncluded.firstElement() && d.Min<body.Min.NotIncluded.lastElement()) {
						toRemove.add(d);
					}
				}
			}
			StatsSet.removeAll(toRemove);
		}
		return StatsSet;
	}
}

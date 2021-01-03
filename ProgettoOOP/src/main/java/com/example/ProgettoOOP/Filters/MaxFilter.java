package com.example.ProgettoOOP.Filters;

import java.util.Vector;

import com.example.ProgettoOOP.Exceptions.FilterException;
import com.example.ProgettoOOP.Types.*;

/**
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class MaxFilter {
	public static Vector<Result> getMaxFilter (BodyStats body,Vector<Result> StatsSet) throws FilterException{
		Vector<Result> toRemove=new Vector<Result>();
		if(body.Max != null) {
			if(body.Max.Greater != 0) {
				for(Result d: StatsSet) {
					if(d.Max<body.Max.Greater) {
						toRemove.add(d);
					}
				}
			}
			else if(body.Max.Less != 0) {
				for(Result d: StatsSet) {
					if(d.Max>body.Max.Less) {
						toRemove.add(d);
					}
				}
			}
			else if(!body.Max.Included.isEmpty()) {
				if(body.Max.Included.size()!=2) {
					throw new FilterException("Illegal number of inputs");
				}
				for(Result d: StatsSet) {
					if(d.Max<body.Max.Included.firstElement() || d.Max>body.Max.Included.lastElement()) {
						toRemove.add(d);
					}
				}
			}
			else if(!body.Max.NotIncluded.isEmpty()) {
				if(body.Max.NotIncluded.size()!=2) {
					throw new FilterException("Illegal number of inputs");
				}
				for(Result d: StatsSet) {
					if(d.Max>body.Max.NotIncluded.firstElement() && d.Max<body.Max.NotIncluded.lastElement()) {
						toRemove.add(d);
					}
				}
			}
			StatsSet.removeAll(toRemove);
		}
		return StatsSet;
	}
}

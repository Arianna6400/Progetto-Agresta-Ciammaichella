package com.example.ProgettoOOP.Filters;

import java.util.Vector;
import com.example.ProgettoOOP.Types.*;

public class AvgFilter {
	public static Vector<Result> getAvgFilter (BodyStats body,Vector<Result> StatsSet){
		Vector<Result> toRemove=new Vector<Result>();
		if(body.Avg != null) {
			if(body.Avg.Greater != 0) {
				for(Result d: StatsSet) {
					if(d.Avg<body.Avg.Greater) {
						toRemove.add(d);
					}
				}
			}
			else if(body.Avg.Less != 0) {
				for(Result d: StatsSet) {
					if(d.Avg>body.Avg.Less) {
						toRemove.add(d);
					}
				}
			}
			else if(!body.Avg.Included.isEmpty()) {
				for(Result d: StatsSet) {
					if(d.Avg<body.Avg.Included.firstElement() || d.Avg>body.Avg.Included.lastElement()) {
						toRemove.add(d);
					}
				}
			}
			else if(!body.Avg.NotIncluded.isEmpty()) {
				for(Result d: StatsSet) {
					if(d.Avg>body.Avg.NotIncluded.firstElement() && d.Avg<body.Avg.NotIncluded.lastElement()) {
						toRemove.add(d);
					}
				}
			}
			StatsSet.removeAll(toRemove);
		}
		return StatsSet;
	}
}

package com.example.ProgettoOOP.Filters;

import java.util.Vector;
import com.example.ProgettoOOP.Types.*;

public class ValueFilter {
	public static Vector<UVData> getValueFilter (BodyData body,Vector<UVData> DataSet){
		Vector<UVData> toRemove=new Vector<UVData>();
		if(body.Value != null) {
			if(body.Value.Greater != 0) {
				for(UVData d: DataSet) {
					if(d.value<body.Value.Greater) {
						toRemove.add(d);
					}
				}
			}
			else if(body.Value.Less != 0) {
				for(UVData d: DataSet) {
					if(d.value>body.Value.Less) {
						toRemove.add(d);
					}
				}
			}
			else if(!body.Value.Included.isEmpty()) {
				for(UVData d: DataSet) {
					if(d.value<body.Value.Included.firstElement() || d.value>body.Value.Included.lastElement()) {
						toRemove.add(d);
					}
				}
			}
			else if(!body.Value.NotIncluded.isEmpty()) {
				for(UVData d: DataSet) {
					if(d.value>body.Value.NotIncluded.firstElement() && d.value<body.Value.NotIncluded.lastElement()) {
						toRemove.add(d);
					}
				}
			}
		}
		DataSet.removeAll(toRemove);
		toRemove.clear();
		return DataSet;
	}
}

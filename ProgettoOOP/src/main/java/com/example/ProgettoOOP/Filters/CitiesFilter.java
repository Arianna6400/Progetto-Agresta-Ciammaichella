package com.example.ProgettoOOP.Filters;

import java.util.Vector;
import com.example.ProgettoOOP.Types.*;

/**
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class CitiesFilter {
	public static Vector<UVData> getCityFilter (BodyData body,Vector<UVData> DataSet){
		boolean flag= false;
		Vector<UVData> toRemove=new Vector<UVData>();
		if(!body.Cities.isEmpty()) {
			for(UVData d : DataSet) {
				for(String name : body.Cities) {
					if(d.name.equals(name)) {
						flag=true;
					}
				}
				if(!flag) {
					toRemove.add(d);
				}
				flag=false;
			}
		}
		DataSet.removeAll(toRemove);
		toRemove.clear();
		return DataSet;
	}
	public static Vector<UVData> getCityFilter (BodyStats body,Vector<UVData> DataSet){
		boolean flag= false;
		Vector<UVData> toRemove=new Vector<UVData>();
		if(!body.Cities.isEmpty()) {
			for(UVData d : DataSet) {
				for(String name : body.Cities) {
					if(d.name.equals(name)) {
						flag=true;
					}
				}
				if(!flag) {
					toRemove.add(d);
				}
				flag=false;
			}
		}
		DataSet.removeAll(toRemove);
		toRemove.clear();
		return DataSet;
	}
}

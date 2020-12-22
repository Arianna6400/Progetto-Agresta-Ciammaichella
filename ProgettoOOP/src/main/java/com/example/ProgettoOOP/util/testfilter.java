package com.example.ProgettoOOP.util;

import java.io.IOException;
import com.example.ProgettoOOP.Filters.*;
import com.example.ProgettoOOP.Types.*;
import java.util.List;

public class testfilter {
	public static String getFilter(test parent) throws IOException {
		List<UVData> DataSet=Reader.getVectorFile();
		if(parent.Value != null) {
			if(parent.Value.Greater != 0) {
				DataSet = GreaterThan.getGreater(DataSet,parent.Value.Greater);
			}
			if(parent.Value.Less != 0) {
				DataSet=LessThan.getLess(DataSet,parent.Value.Less);
			}
			if(parent.Value.Included != null  ) {
				DataSet=Included.getIncluded(DataSet,parent.Value.Included.get(0),parent.Value.Included.get(1));
			}
			if(parent.Value.NotIncluded!= null ) {
				DataSet=NotIncluded.getNotIncluded(DataSet,parent.Value.NotIncluded.get(0),parent.Value.NotIncluded.get(1));
			}
		}
		if(parent.Date!= null) {
			if(parent.Date.Greater != 0) {
				DataSet=GreaterThan.getGreater(DataSet,parent.Date.Greater);
			}
			if(parent.Date.Less != 0) {
				DataSet=LessThan.getLess(DataSet,parent.Date.Less);
			}
			if(parent.Date.Included != null  ) {
				DataSet=Included.getIncluded(DataSet,parent.Date.Included.get(0),parent.Date.Included.get(1));
			}
			if(parent.Date.NotIncluded!= null ) {
				DataSet=NotIncluded.getNotIncluded(DataSet,parent.Date.NotIncluded.get(0),parent.Date.NotIncluded.get(1));
			}
		}
		return "not found";
	}
}

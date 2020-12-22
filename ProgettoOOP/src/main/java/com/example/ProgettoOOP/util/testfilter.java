package com.example.ProgettoOOP.util;

import java.io.IOException;
import com.example.ProgettoOOP.Filters.*;
import com.example.ProgettoOOP.Types.*;

public class testfilter {
	public static String getFilter(test parent) throws IOException {
		if(parent.Value != null) {
			if(parent.Value.Greater != 0) {
				return (GreaterThan.getGreater(parent.Value.Greater));
			}
			if(parent.Value.Less != 0) {
				return(LessThan.getLess(parent.Value.Less));
			}
			if(parent.Value.Included != null  ) {
				return(Included.getIncluded(parent.Value.Included.get(0),parent.Value.Included.get(1)));
			}
			if(parent.Value.NotIncluded!= null ) {
				return(NotIncluded.getNotIncluded(parent.Value.NotIncluded.get(0),parent.Value.NotIncluded.get(1)));
			}
		}
		if(parent.Date!= null) {
			if(parent.Date.Greater != 0) {
				return (GreaterThan.getGreater(parent.Date.Greater));
			}
			if(parent.Date.Less != 0) {
				return(LessThan.getLess(parent.Date.Less));
			}
			if(parent.Date.Included != null  ) {
				return(Included.getIncluded(parent.Date.Included.get(0),parent.Date.Included.get(1)));
			}
			if(parent.Date.NotIncluded!= null ) {
				return(NotIncluded.getNotIncluded(parent.Date.NotIncluded.get(0),parent.Date.NotIncluded.get(1)));
			}
		}
		return "not found";
	}
}

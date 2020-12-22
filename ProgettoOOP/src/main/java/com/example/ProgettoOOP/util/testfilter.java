package com.example.ProgettoOOP.util;

import java.io.IOException;
import com.example.ProgettoOOP.Filters.*;
import com.example.ProgettoOOP.Types.*;

public class testfilter {
	public static String getFilter(Value value) throws IOException {
		if(value.Greater != 0) {
			return (GreaterThan.getGreater(value.Greater));
			}
		if(value.Less != 0) {
			return(LessThan.getLess(value.Less));
			}
		if(value.Included != null  ) {
			return(Included.getIncluded(value.Included.get(0),value.Included.get(1)));
			}
		if(value.NotIncluded!= null ) {
			return(NotIncluded.getNotIncluded(value.NotIncluded.get(0),value.NotIncluded.get(1)));
			}
		return "not found";
	}
}

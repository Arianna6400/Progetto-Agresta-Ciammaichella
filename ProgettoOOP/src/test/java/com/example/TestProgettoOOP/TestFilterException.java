package com.example.TestProgettoOOP;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.ProgettoOOP.Exceptions.FilterException;
import com.example.ProgettoOOP.Filters.*;
import com.example.ProgettoOOP.Types.*;
import com.example.ProgettoOOP.util.Reader;

class TestFilterException {
	private ValueFilter t1;
	private BodyData body;
	Vector<UVData> DataSet= new Vector<UVData>();;
	@BeforeEach
	void setUp() throws Exception {
		DataSet = Reader.getVectorUV();
		t1 = new ValueFilter();
		Vector<Double> Included = new Vector<Double>();
		Included.add(1.0);
		FilterField Value = new FilterField(0,0,Included,null);
		body = new BodyData (null,null,Value);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		FilterException exception = assertThrows(FilterException.class, () ->{
			t1.getValueFilter(body, DataSet);
		});
		assertEquals("Illegal number of inputs",exception.getMessage());
	}

}

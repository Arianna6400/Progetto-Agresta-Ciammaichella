package com.example.TestProgettoOOP;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.ProgettoOOP.Types.UVData;
import com.example.ProgettoOOP.util.Time;

class TestTime {
	private Time t1;
	Vector<UVData> FilteredVector = new Vector<UVData>();
	Vector<Integer> Range=  new Vector<Integer>();;
	Vector<Long> FilteredRange = new Vector<Long>();
	@BeforeEach
	void setUp() throws Exception {
		UVData CityData1= new UVData(null,null,1610020800,0.0);
		FilteredVector.add(CityData1);
		Range.add(0);
		Range.add(1);
		FilteredRange.add((long) 1610020800);
		FilteredRange.add((long) 1609934400);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test1() {
		assertEquals(FilteredRange,t1.getRange(FilteredVector, Range));
	}
	@Test
	void test2() {
		assertEquals(FilteredRange,t1.getStatsRange(FilteredVector, 0 , 1));
	}
}

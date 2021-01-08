package com.example.TestProgettoOOP;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.ProgettoOOP.Exceptions.MissingFileException;
import com.example.ProgettoOOP.util.*;

class TestMissingFileException {
	private Reader t1;
	@BeforeEach
	void setUp() throws Exception {
		t1=new Reader();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test1() {
		MissingFileException exception = assertThrows(MissingFileException.class, () ->{
			t1.getVectorUV();
		});
		assertEquals("Json file not found in the folder",exception.getMessage());
	}
	@Test
	void test2() {
		MissingFileException exception = assertThrows(MissingFileException.class, () ->{
			t1.getVectorCity();
		});
		assertEquals("Json file not found in the folder",exception.getMessage());
	}
}

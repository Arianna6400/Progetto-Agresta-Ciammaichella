package com.example.ProgettoOOP.util;

import java.util.Vector;

import com.example.ProgettoOOP.Types.*;
import com.google.gson.Gson;

public class BodyParser {
	public static Vector<String> getBody(String test) {
		Gson gson = new Gson();
		Body body = gson.fromJson(test, Body.class);
		
		
		return body.Cities;
	}
	
}

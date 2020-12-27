package com.example.ProgettoOOP.Service;

import java.util.List;
import java.util.Vector;

import com.example.ProgettoOOP.Rate.Massimo;
import com.example.ProgettoOOP.Rate.Media;
import com.example.ProgettoOOP.Rate.Minimo;
import com.example.ProgettoOOP.Rate.Varianza;
import com.example.ProgettoOOP.Types.Result;
import com.example.ProgettoOOP.Types.UVData;
import com.example.ProgettoOOP.util.Time;
public class Calculator {
	 static Vector<UVData> Pescara = new Vector<UVData>();
	 static Vector<UVData> Ancona = new Vector<UVData>();
	 static Vector<UVData> Milan = new Vector<UVData>();
	 static Vector<UVData> Rome = new Vector<UVData>();
     static Vector<UVData> Venice = new Vector<UVData>();
	public static void ListParser(Vector<UVData> DataList) {
		for(UVData d : DataList) {
			if(d.name.equals("Pescara")) {
				Pescara.add(d);
			}
			else if(d.name.equals("Ancona")) {
				Ancona.add(d);
			}
			else if(d.name.equals("Rome")) {
				Rome.add(d);
			}
			else if(d.name.equals("Milan")) {
				Milan.add(d);
			}
			else if(d.name.equals("Venice")) {
				Venice.add(d);
			}	
		}
	}
	public static Vector<UVData> getPescara(){
		return Pescara;
	}
	public static Vector<UVData> getAncona(){
		return Ancona;
	}
	public static Vector<UVData> getRome(){
		return Rome;
	}
	public static Vector<UVData> getMilan(){
		return Milan;
	}
	public static Vector<UVData> getVenice(){
		return Venice;
	}
}

package com.example.ProgettoOOP.Types;

import java.util.Vector;

public class Value {
	public double Greater;
	public double Less;
	public Vector<Double> Included = new Vector<Double>(2); 
	public Vector<Double> NotIncluded = new Vector<Double>(2); 
	
	public Value (double Greater,double Less,Vector<Double> Included,Vector<Double> NotIncluded) {
		this.Greater=Greater;
		this.Less=Less;
		this.Included=Included;
		this.NotIncluded=NotIncluded;
	}
	public double getGreater() {
		return Greater;
	}
	public double getLess() {
		return Less;
	}
	public Vector<Double> getIncluded() {
		return Included;
	}
	public Vector<Double> getNotIncluded() {
		return NotIncluded;
	}
	public void setGreater(double greater) {
		Greater = greater;
	}
	public void setLess(double less) {
		Less = less;
	}
	public void setIncluded(Vector<Double> included) {
		Included = included;
	}
	public void setNotIncluded(Vector<Double> notIncluded) {
		NotIncluded = notIncluded;
	}
	
}

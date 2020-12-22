package com.example.ProgettoOOP.util;

//import com.example.ProgettoOOP.Types.Value;
//import com.fasterxml.jackson.databind.ObjectMapper;

public class Time {
	public static long getTimeGion(long Time) {
		return Time-(24*60*60);
	}
	public static long getTimeSett(long Time) {
		return Time-(24*60*60*7);
	}
	public static long getTimeMes(long Time) {
		return Time-(24*60*60*30);
	}
	public static long getTime5g(long Time) {
		return Time-(24*60*60*5);
	}
	public static long getTime10g(long Time) {
		return Time-(24*60*60*10);
	}
	/*public static double test(Object value) {
		Value test = new ObjectMapper().convertValue(value, Value.class);
		return test.getGreater();
	}*/
}

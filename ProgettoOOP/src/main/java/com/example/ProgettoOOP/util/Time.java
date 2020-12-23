package com.example.ProgettoOOP.util;


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
}

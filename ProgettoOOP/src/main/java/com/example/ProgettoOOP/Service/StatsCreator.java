package com.example.ProgettoOOP.Service;

import java.util.Vector;

import com.example.ProgettoOOP.Types.Result;
import com.google.gson.Gson;

public class StatsCreator {
	public static String getStats(Result Pescara,Result Ancona,Result Milan,Result Rome,Result Venice) {
		Vector<Result> Stats=new Vector<Result>();
		Stats.add(Pescara);
		Stats.add(Ancona);
		Stats.add(Rome);
		Stats.add(Milan);
		Stats.add(Venice);
		Gson gson= new Gson();
		String statsJson = gson.toJson(Stats);
		return statsJson;
	}
}

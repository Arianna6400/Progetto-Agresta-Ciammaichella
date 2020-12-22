package com.example.ProgettoOOP.Service;

import java.util.Vector;

import com.example.ProgettoOOP.Rate.Massimo;
import com.example.ProgettoOOP.Rate.Media;
import com.example.ProgettoOOP.Rate.Minimo;
import com.example.ProgettoOOP.Rate.Varianza;
import com.example.ProgettoOOP.Types.Result;
import com.example.ProgettoOOP.Types.UVData;
import com.example.ProgettoOOP.util.Time;

public class DataCity {
	public static Result getResult (Vector<UVData> City)  {
		Result result = new Result(); 
		Vector<Double> GionValue = new Vector<Double>();
		Vector<Double> SettValue = new Vector<Double>();
		Vector<Double> MeseValue = new Vector<Double>();
		Vector<Double> CinquegValue = new Vector<Double>();
		Vector<Double> DiecigValue = new Vector<Double>();
		
		for(UVData d : City) {
			if(d.date > Time.getTimeGion(City.lastElement().date)) {
				GionValue.add(d.value);
			}
		}
		result.MaxGion=Massimo.getMassimo(GionValue);
		result.MinGion=Minimo.getMinimo(GionValue);
		result.MedGion=Media.getMedia(GionValue);
		result.VarGion=Varianza.getVarianza(GionValue);
		
		for(UVData s : City) {
			if(s.date > Time.getTimeSett(City.lastElement().date)) {
				SettValue.add(s.value);
			}
		}
		result.MaxSett=Massimo.getMassimo(SettValue);
		result.MinSett=Minimo.getMinimo(SettValue);
		result.MedSett=Media.getMedia(SettValue);
		result.VarSett=Varianza.getVarianza(SettValue);
		
		for(UVData m : City) {
			if(m.date > Time.getTimeMes(City.lastElement().date)) {
				MeseValue.add(m.value);
			}
		}
		result.MaxMese=Massimo.getMassimo(MeseValue);
		result.MinMese=Minimo.getMinimo(MeseValue);
		result.MedMese=Media.getMedia(MeseValue);
		result.VarMese=Varianza.getVarianza(MeseValue);
		
		for(UVData cg : City) {
			if(cg.date > Time.getTime5g(City.lastElement().date)) {
				CinquegValue.add(cg.value);
			}
		}
		result.Max5g=Massimo.getMassimo(CinquegValue);
		result.Min5g=Minimo.getMinimo(CinquegValue);
		result.Med5g=Media.getMedia(CinquegValue);
		result.Var5g=Varianza.getVarianza(CinquegValue);
		
		for(UVData dg : City) {
			if(dg.date > Time.getTime10g(City.lastElement().date)) {
				DiecigValue.add(dg.value);
			}
		}
		result.Max10g=Massimo.getMassimo(DiecigValue);
		result.Min10g=Minimo.getMinimo(DiecigValue);
		result.Med10g=Media.getMedia(DiecigValue);
		result.Var10g=Varianza.getVarianza(DiecigValue);
		result.CityName=City.firstElement().name;
		
		return result;
	}
}

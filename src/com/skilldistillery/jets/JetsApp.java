package com.skilldistillery.jets;

import java.util.*;

public class JetsApp {

	public static void main(String[] args) {
		CargoPlane cp = new CargoPlane("Cessna", 50, 300, 1_000);
		cp.loadCargo();
//		System.out.println(cp.toString());
		FighterJet fj = new FighterJet("F16",500,1000,20_000);
		AirField field = new AirField();
		FighterJet fr = new FighterJet("F16",500,1000,20_000);
		ArrayList <Jet> jetArr = new ArrayList<>(); 
		jetArr.add(cp);
		jetArr.add(fj);
		jetArr.add(fr);
		field.setJets(jetArr);
//		System.out.println(field.getJets().toString());
		System.out.println(field.toString());
	}

}

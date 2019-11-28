package com.skilldistillery.jets;

import java.util.*;

public class AirField {
	private List<Jet> jets;
	
	public AirField() {
		jets = new ArrayList<>();
	}

	public List<Jet> getJets() {
		return jets;
	}

	public void setJets(List<Jet> jets) {
		this.jets = jets;
	}

	@Override
	public String toString() {
		return "AirField [jets=" + jets + "]";
	}

}

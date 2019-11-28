package com.skilldistillery.jets;
public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fight() {
		System.out.println("Pew pew pew, bogies on my 6");

	}

	@Override
	public String toString() {
		return "FighterJet [getModel()=" + getModel() + ", getSpeed()=" + getSpeed() + ", \ngetRange()=" + getRange()
				+ ", getPrice()=" + getPrice() + ", getClass()=" + getClass().getSimpleName() + "]\n";
	}


	

}

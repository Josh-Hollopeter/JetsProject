package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void loadCargo() {
		System.out.println("....Loading cargo");
	}

	@Override
	public String toString() {
		return "[Model=" + getModel() + ", Speed=" + getSpeed() + ", Range()=" + getRange()
				+ ", \nPrice=" + getPrice() + ", Class=" + getClass().getSimpleName() + "]\n";
	}



}

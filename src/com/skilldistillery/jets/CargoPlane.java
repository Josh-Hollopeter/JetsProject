package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void loadCargo() {
		System.out.println(this.toString() + " ....Loading cargo");
	}

	@Override
	public String toString() {
		return "[Model=" + getModel() + ", Speed=" + getSpeed() + ", Range=" + getRange() + ", Price=" + getPrice()
				+ ", Class=" + getClass().getSimpleName() + "]\n";
	}

	public void fly() {
		System.out.printf(
				this.getClass().getSimpleName() + "[Model=" + getModel() + ", Speed=" + getSpeed() + ", Range="
						+ getRange() + ", Price=" + getPrice() + " Flight Time %.2f hours Mach= %.2f ]\n",
				flightTime(), machSpeed());
	}
	@Override
	public double flightTime() {
		return this.getRange() / this.getSpeed();
		
	}
	@Override
	public double machSpeed() {
		return this.getSpeed()/super.getMachMod();
		
	}
}

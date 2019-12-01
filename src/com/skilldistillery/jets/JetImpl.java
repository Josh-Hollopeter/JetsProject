package com.skilldistillery.jets;

public class JetImpl extends Jet {

	public JetImpl(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public String toString() {
		return "[Model=" + getModel() + ", Speed=" + getSpeed() + ", Range=" + getRange() + ", Price=" + getPrice()
				+ ", Class=" + this.getClass().getSimpleName() + "]\n";
	}

	@Override
	public void fly() {
		System.out.printf(
				this.getClass().getSimpleName() + "[Model=" + getModel() + ", Speed=" + getSpeed() + ", Range="
						+ getRange() + ", Price=" + getPrice() + " Flight Time %.2f hours Mach= %.2f ]\n",
				getRange() / getSpeed(), getSpeed() / 767.269);
	}
}

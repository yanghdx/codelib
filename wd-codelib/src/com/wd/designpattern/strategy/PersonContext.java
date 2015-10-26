package com.wd.designpattern.strategy;

public class PersonContext {

	private ITravel travel;
	
	public void setTravelStrategy(ITravel travel) {
		this.travel = travel;
	}
	
	public void travel() {
		this.travel.travel();
	}
	
	
	public static void main(String[] args) {
		PersonContext p = new PersonContext();
		p.setTravelStrategy(new CarTravel());
		p.travel();
		
		p.setTravelStrategy(new AirTravel());
		p.travel();
	}
}

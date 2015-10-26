package com.wd.designpattern.state;

public class State {

	private String stateValue;

	public State(String stateValue) {
		this.stateValue = stateValue;
	}
	public String getStateValue() {
		return stateValue;
	}

	public void setStateValue(String stateValue) {
		this.stateValue = stateValue;
	}
	
	
	public void methodOne() {
		System.out.println("State one");
	}
	
	
	public void methodTwo() {
		System.out.println("State two");
	}
}

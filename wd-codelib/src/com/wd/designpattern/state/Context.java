package com.wd.designpattern.state;

public class Context {

	private State state;
	
	public Context(State state) {
		this.state = state;
	}
	
	public void method() {
		if (state.getStateValue().equals("one")) {
			state.methodOne();
		} else if (state.getStateValue().equals("one")) {
			state.methodTwo();
		}
	}
}

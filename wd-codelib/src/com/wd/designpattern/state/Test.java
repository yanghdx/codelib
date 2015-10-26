package com.wd.designpattern.state;

public class Test {

	public static void main(String[] args) {
		State state = new State("one");
		Context ctx = new Context(state);
		ctx.method();
		state.setStateValue("two");
		ctx.method();
	}

}

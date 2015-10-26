package com.wd.designpattern.command;

public class Invoker {

	private Command command;
	
	public Invoker(Command command) {
		this.command = command;
	}
	
	public void invoke() {
		this.command.execute();
	}
}

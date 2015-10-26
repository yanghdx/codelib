package com.wd.designpattern.command;

public class Test {

	public static void main(String[] args) {
		Command command = new MyCommand(new Receiver());
		Invoker inv = new Invoker(command);
		inv.invoke();
	}

}

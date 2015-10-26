package com.wd.designpattern.decorator;

public class Decorator implements Sourceable {

	private Sourceable source;
	
	public Decorator(Sourceable source) {
		this.source = source;
	}
	@Override
	public void sourceMethod() {
		System.out.println("Before source method");
		source.sourceMethod();
		System.out.println("After source method");
	}

}

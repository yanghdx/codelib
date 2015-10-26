package com.wd.designpattern.bridge;

public class SourceSubOne implements Sourceable {

	@Override
	public void sourceMethod() {
		System.out.println("One: source method");
	}

}

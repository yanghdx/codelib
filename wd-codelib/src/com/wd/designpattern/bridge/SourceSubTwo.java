package com.wd.designpattern.bridge;

public class SourceSubTwo implements Sourceable {

	@Override
	public void sourceMethod() {
		System.out.println("Two: source method");
	}

}

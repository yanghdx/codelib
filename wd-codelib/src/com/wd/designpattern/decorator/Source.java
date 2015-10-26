package com.wd.designpattern.decorator;

public class Source implements Sourceable {

	@Override
	public void sourceMethod() {
		System.out.println("Source method.");
	}

}

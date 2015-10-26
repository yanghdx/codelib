package com.wd.designpattern.adapter;

public class Wrapper implements Targetable {

	private Source source;
	
	public Wrapper(Source source) {
		this.source = source;
	}
	
	public void sourceMethod() {
		source.sourceMethod();
	}
	
	@Override
	public void targetMethod() {
		System.out.println("This is target method.");
	}

}

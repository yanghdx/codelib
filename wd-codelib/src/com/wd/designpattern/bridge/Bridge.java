package com.wd.designpattern.bridge;

public abstract class Bridge {

	private Sourceable source;
	
	//source method
	public void sourceMethod() {
		source.sourceMethod();
	}
	//getter setter
	public Sourceable getSource() {
		return source;
	}

	public void setSource(Sourceable source) {
		this.source = source;
	}
	
	 
}

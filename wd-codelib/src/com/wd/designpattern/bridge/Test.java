package com.wd.designpattern.bridge;

public class Test {

	public static void main(String[] args) {
		Bridge bri = new MyBridge();
		//source one
		bri.setSource(new SourceSubOne());
		bri.sourceMethod();
		//source two
		bri.setSource(new SourceSubTwo());
		bri.sourceMethod();
	}

}

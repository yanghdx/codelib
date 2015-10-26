package com.wd.designpattern.decorator;

public class Test {

	public static void main(String[] args) {
		Decorator dec = new Decorator(new Source());
		dec.sourceMethod();

	}

}

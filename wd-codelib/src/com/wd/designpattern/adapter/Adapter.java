package com.wd.designpattern.adapter;

public class Adapter extends Source implements Targetable {

	@Override
	public void targetMethod() {
		System.out.println("This is target method");
	}

}

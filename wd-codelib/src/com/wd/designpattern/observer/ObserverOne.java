package com.wd.designpattern.observer;

public class ObserverOne implements Observer {

	@Override
	public void update() {
		System.out.println("One received.");
	}

}

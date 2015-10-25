package com.wd.designpattern.observer;

public class ObserverTwo implements Observer {

	@Override
	public void update() {
		System.out.println("Two received.");
	}

}

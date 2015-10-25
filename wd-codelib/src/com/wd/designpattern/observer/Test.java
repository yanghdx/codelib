package com.wd.designpattern.observer;

public class Test {

	public static void main(String[] args) {
		Subject sub = new MySubject();
		sub.add(new ObserverOne());
		sub.add(new ObserverTwo());
		
		sub.notifyObservers();
	}

}

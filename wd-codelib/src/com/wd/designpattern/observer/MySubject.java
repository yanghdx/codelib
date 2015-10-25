package com.wd.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class MySubject implements  Subject {

	private List<Observer> obs = new ArrayList<Observer>();
	@Override
	public void add(Observer ob) {
		obs.add(ob);
	}

	@Override
	public void delete(Observer ob) {
		obs.remove(ob);
	}

	@Override
	public void notifyObservers() {
		for (Observer ob : obs) {
			ob.update();
		}
	}

}

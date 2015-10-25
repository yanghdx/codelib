package com.wd.designpattern.observer;

public interface Subject {

	void add(Observer ob);
	
	void delete(Observer ob);
	
	void notifyObservers();
}

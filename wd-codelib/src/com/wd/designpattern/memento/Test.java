package com.wd.designpattern.memento;

public class Test {

	public static void main(String[] args) {
		Original o = new Original("Apple");
		Storage s = new Storage(o.createMemento());
		o.setValue("Orange");
		
		o.restoreMemento(s.getMemento());
		//print
	}
}

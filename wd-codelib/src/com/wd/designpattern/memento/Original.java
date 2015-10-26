package com.wd.designpattern.memento;

public class Original {

	private String value;
	
	public Original(String value) {
		this.value = value;
	}
	//getter setter
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	//create、restore
	public Memento createMemento() {
		return new Memento(this.value);
	}
	
	public void restoreMemento(Memento memento){  
	    this.value = memento.getValue();  
	}
}

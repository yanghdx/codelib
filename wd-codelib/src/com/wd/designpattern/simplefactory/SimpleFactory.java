package com.wd.designpattern.simplefactory;

public class SimpleFactory {

	
	private static final SimpleFactory INSTANCE = new SimpleFactory();
	
	private SimpleFactory() {
		
	}
	
	public static SimpleFactory getInstance() {
		return INSTANCE;
	}
	
	
	public ICar getCar(String name) {
		if ("benz".equals(name)) {
			return new Benz();
		} else if ("bmw".equals(name)) {
			return new Bmw();
		} else {
			return new ICar(){
				public void drive() {
					System.out.println("car driving..");
				}
			};
		}
	}
	
	
	public static void main(String[] args) {
		ICar car = SimpleFactory.getInstance().getCar("benz");
		car.drive();
		
		car = SimpleFactory.getInstance().getCar("bmw");
		car.drive();
		
	}
	
}

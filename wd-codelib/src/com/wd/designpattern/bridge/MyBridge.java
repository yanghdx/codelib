package com.wd.designpattern.bridge;

public class MyBridge extends Bridge {

	 public void sourceMethod() {
		 getSource().sourceMethod();
	 }
}

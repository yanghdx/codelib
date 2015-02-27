package com.wd.designpattern.singleton;

/**
 * 单例 - 加锁
 * @author  yang_huidi
 * @version 1.00
 * @date    2015年2月27日
 * @see        
 * 
 */
public class SingletonDemo2 {
	
	private SingletonDemo2() {
		
	}
	
	private static SingletonDemo2 INSTANCE = null;
	
	
	public static SingletonDemo2 getInstance() {
		if (INSTANCE == null) {
			synchronized (SingletonDemo2.class) {
				if (INSTANCE == null) {
					INSTANCE = new SingletonDemo2();
				}
			}
		}
		return INSTANCE;
	}
}

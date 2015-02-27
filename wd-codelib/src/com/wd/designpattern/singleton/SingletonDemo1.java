package com.wd.designpattern.singleton;

/**
 * 
 * 单例 - 最简单形式
 * @author  yang_huidi
 * @version 1.00
 * @date    2015年2月27日
 * @see        
 * 
 */
public class SingletonDemo1 {

	private SingletonDemo1() {
		
	}
	
	private static SingletonDemo1 INSTANCE = new SingletonDemo1();
	
	
	public static SingletonDemo1 getInstance() {
		return INSTANCE;
	}
}

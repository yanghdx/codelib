package com.wd.designpattern.singleton;

/**
 *
 * 单例 - 使用内部类
 * 
 * @author  yang_huidi
 * @version 1.00
 * @date    2015年2月27日
 * @see        
 * 
 */
public class SingletonDemo3 {

	private SingletonDemo3() {
		
	}
	
	public static SingletonDemo3 getInstance() {
		return Holder.INSTANCE;
	}
	
	private static class Holder {
		private static final SingletonDemo3 INSTANCE = new SingletonDemo3();
	}
}

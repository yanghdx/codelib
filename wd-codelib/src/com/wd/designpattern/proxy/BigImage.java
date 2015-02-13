package com.wd.designpattern.proxy;

/**
 * BigImage: new此对象时开销比较大，但是此图片应用率较低
 * @author  yang_huidi
 * @version 1.00
 * @date    2015年2月13日
 * @see        
 * 
 */
public class BigImage implements IImage {

	public BigImage() {
		try {
			Thread.sleep(3000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void show() {
		System.out.println("show big image");
	}

}

package com.wd.designpattern.proxy;

/**
 *
 * 对大图片进行代理，只有实际show的时候才new BigImage
 * @author  yang_huidi
 * @version 1.00
 * @date    2015年2月13日
 * @see        
 * 
 */
public class BigImageProxy implements IImage {

	private BigImage image = null;
	
	@Override
	public void show() {
		if (image == null) {
			image = new BigImage();
		}
		image.show();
	}

}

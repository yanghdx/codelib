package com.wd.cache;

/**
 *
 * 一次性缓存的handler接口，用来获取数据，然后放入缓存
 * 
 * @author  yang_huidi
 * @version 1.00
 * @date    2015年1月28日
 * @see        
 * 
 */
public interface IOneTimeCacheHandler {

	/**
	 * 用来读取数据
	 * @author yang_huidi
	 * @return  
	 */
	
	Object get(Object key);
}

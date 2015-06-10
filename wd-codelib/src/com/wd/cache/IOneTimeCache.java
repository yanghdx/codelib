package com.wd.cache;


/**
 *
 * 一次性缓存类
 * 应用场景：可用于方法内部的临时缓存，方法结束后缓存也结束
 * @author  yang_huidi
 * @version 1.00
 * @date    2015年1月28日
 * @see        
 * 
 */
public interface IOneTimeCache {

	/**
	 * 设置处理类
	 * @author yang_huidi
	 * @param handler  
	 */
	
	void setHandler(IOneTimeCacheHandler handler);
	/**
	 * 根据key获取数据
	 * @author yang_huidi
	 * @param key
	 * @return  
	 */
	
	Object get(Object key);
	/**
	 * 重置缓存
	 * @author yang_huidi
	 */
	void reset();
	
	/**
	 * 销毁缓存
	 * @author yang_huidi
	 */
	void destory();
}

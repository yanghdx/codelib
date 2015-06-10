package com.wd.cache.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.wd.cache.IOneTimeCache;
import com.wd.cache.IOneTimeCacheHandler;

/**
 * 一次性map缓存
 * 
 * @author  yang_huidi
 * @version 1.00
 * @date    2015年1月28日
 * @see        
 * 
 */
public class OneTimeMapCache implements IOneTimeCache {

	private static final Logger LOGGER = Logger.getLogger(OneTimeMapCache.class);
	//获取数据的handler
	private IOneTimeCacheHandler handler;
	//实际缓存
	public Map<Object, Object> cache = new HashMap<Object, Object>();
	
	public OneTimeMapCache() {
		
	}
	
	public OneTimeMapCache(IOneTimeCacheHandler handler) {
		this.handler = handler;
	}
	
	@Override
	public void setHandler(IOneTimeCacheHandler handler) {
		this.handler = handler;
	}

	@Override
	public Object get(Object key) {
		if (key == null) {
			LOGGER.debug("key is null!");
			return null;
		}
		if (cache == null) {
			LOGGER.warn("cache is null, maybe had destoryed!");
			throw new NullPointerException("cache is null, maybe had destoryed!");
		}
		if (cache.containsKey(key)) {
			return cache.get(key);
		} else {
			if (handler != null) {
				Object val = handler.get(key);
				cache.put(key, val);//put into cache
				return val;
			} else {
				LOGGER.warn("handler is null!");
				return null;
			}
		}
	}

	@Override
	public void reset() {
		cache = new HashMap<Object, Object>();
	}
	
	@Override
	public void destory() {
		cache = null;
	}

}

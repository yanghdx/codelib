package com.wd.cache.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.wd.cache.IGlobalCache;

/**
 * 全局缓存
 * @author  yang_huidi
 * @version 1.00
 * @date    2014年6月17日
 * @see        
 * 
 */
public class GlobalCache implements IGlobalCache {
	
	/** logger */
	private static final Logger LOGGER = Logger.getLogger(GlobalCache.class);
	/**   
	 *  单例模式
	 */   
	private static GlobalCache cache = new GlobalCache();;
	
	/** 默认分组名 */
	private static final String DEFAULT_GROUP = "__default__";
	
	/**
	 * 缓存map对象
	 */
	private Map<String, Map<String, Object>> cacheMap = null;
	

	/**
	 * 私有构造方法
	 * create a instance  GlobalCache.
	 */
	private GlobalCache () {
		init();
	}
	
	
	public static GlobalCache getInstance() {
		
		return cache;
	}

	@Override
	public void init() {
		//同步操作
		synchronized (this) {
			if (cacheMap == null) {
				cacheMap = new ConcurrentHashMap<String, Map<String, Object>>();
				//放入默认分组
				Map<String, Object> defaultGroup = new HashMap<String, Object>();
				cacheMap.put(DEFAULT_GROUP, defaultGroup);
			}
		}
	}

	@Override
	public void put(String key, Object value) {
		if (key == null) {
			return;
		}
		Map<String, Object> map = cacheMap.get(DEFAULT_GROUP);
		if (map == null) {
			map = new HashMap<String, Object>();
			cacheMap.put(DEFAULT_GROUP, map);
		}
		map.put(key, value);

	}

	@Override
	public void put(String key, Object value, String group) {
		if (key == null || group == null) {
			return;
		}
		Map<String, Object> map = cacheMap.get(group);
		if (map == null ) {
			map = new HashMap<String, Object>();
			cacheMap.put(group, map);
		}
		map.put(key, value);

	}

	@Override
	public void putGroup(String group) {
		if (group == null) {
			LOGGER.warn("GlobalCache:addGroup - group name is null! return!");
			return;
		}
		if (DEFAULT_GROUP.equals(group)) {
			LOGGER.warn("GlobalCache:addGroup - cannot add default group! return!");
			return;
		}
		cacheMap.put(group, new HashMap<String, Object>());
	}
	
	@Override
	public void putGroup(String group, Map<String, Object> map) {
		if (group == null) {
			LOGGER.warn("GlobalCache:addGroup - group name is null! return!");
			return;
		}
		if (DEFAULT_GROUP.equals(group)) {
			LOGGER.warn("GlobalCache:addGroup - cannot add default group! return!");
			return;
		}
		if (map == null) {
			map = new HashMap<String, Object>();
		}
		cacheMap.put(group, map);
	}

	@Override
	public Object get(String key) {
		Map<String, Object> map = cacheMap.get(DEFAULT_GROUP);
		if (map != null) {
			return map.get(key);
		}
		return null;
	}

	@Override
	public Object get(String key, String group) {
		Map<String, Object> map = cacheMap.get(group);
		if (map != null) {
			return map.get(key);
		}
		return null;
	}

	@Override
	public Map<String, Object> getGroup(String group) {
		return cacheMap.get(group);
	}

	@Override
	public void remove(String key) {
		Map<String, Object> map = cacheMap.get(DEFAULT_GROUP);
		if (map != null) {
			map.remove(key);
		}

	}

	@Override
	public void remove(String key, String group) {
		Map<String, Object> map = cacheMap.get(group);
		if (map != null) {
			map.remove(key);
		}

	}

	@Override
	public void removeGroup(String group) {
		if (DEFAULT_GROUP.equals(group)) {
			LOGGER.warn("GlobalCache:removeGroup cannot remove default group! return!");
			return;
		}
		cacheMap.remove(group);

	}

	@Override
	public void destory() {
		cacheMap = null;
	}
	
	public void reset() {
		destory();
		init();
	}

}

package com.wd.cache;

import java.util.Map;

public interface IGlobalCache {

	
	/**
	 * 初始化缓存
	 * @author yang_huidi  
	 */
	
	void init();
	
	/**
	 * 
	 * @author yang_huidi
	 * @param key
	 * @param obj  
	 */
	
	void put(String key, Object value);
	
	
	/**
	 * 
	 * @author yang_huidi
	 * @param key
	 * @param value
	 * @param group  
	 */
	
	void put(String key, Object value, String group);
	
	
	
	/**
	 * 
	 * @author yang_huidi
	 * @param group
	 * @param value  
	 */
	
	void putGroup(String group);
	
	/**
	 * 
	 * @author yang_huidi
	 * @param group
	 * @param value  
	 */
	
	void putGroup(String group, Map<String, Object> value);
	
	/**
	 * 
	 * @author yang_huidi
	 * @param key
	 * @return  
	 */
	
	Object get(String key);
	
	
	
	/**
	 * 
	 * @author yang_huidi
	 * @param key
	 * @param group
	 * @return  
	 */
	
	Object get(String key, String group);
	
	
	
	/**
	 * 
	 * @author yang_huidi
	 * @param group
	 * @return  
	 */
	
	Map<String, Object> getGroup(String group);
	/**
	 * 
	 * @author yang_huidi
	 * @param key
	 * @param group  
	 */
	
	void remove(String key);
	

	
	/**
	 * 
	 * @author yang_huidi
	 * @param key
	 * @param group  
	 */
	
	void remove(String key, String group);
	
	
	
	/**
	 * 
	 * @author yang_huidi
	 * @param group  
	 */
	
	void removeGroup(String group);
	
	/**
	 * 
	 * @author yang_huidi  
	 */
	
	void destory();
	
	
	
	/**
	 * 重置缓存
	 * @author yang_huidi  
	 */
	
	void reset();
}

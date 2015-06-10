package com.wd.cache;

import java.util.HashMap;
import java.util.Map;

import com.wd.cache.impl.GlobalCache;
import com.wd.cache.impl.OneTimeMapCache;

public class TestCache {
	
	Map<Object, Object> service = new HashMap<Object, Object>();
	
	public TestCache() {
		service.put("1", "1");
		service.put("2", "2");
		service.put("3", "3");
	}
	
	
	
	class TestHandler implements IOneTimeCacheHandler{
		@Override
		public Object get(Object key) {
			return service.get(key);
		}
	}
	
	
	public void test() {
		// one time cache
		IOneTimeCache otc = new OneTimeMapCache(new TestHandler());
		System.out.println(otc.get("1"));
		System.out.println(otc.get("1"));
		System.out.println(otc.get("2"));
		System.out.println(otc.get("2"));
		System.out.println(otc.get("4"));
		System.out.println(otc.get("4"));
	}
	public static void main(String[] args) {
		IGlobalCache cache = GlobalCache.getInstance();
		IGlobalCache cache2 = GlobalCache.getInstance();
		cache.put("key", "value");
		cache.put("key1", "value1", "group1");
		cache.put("key3", "value3");

		System.out.println((String)cache2.get("key"));
		System.out.println((String)cache2.get("key1", "group1"));
		System.out.println((String)cache2.get("key3"));
		
		new TestCache().test();
		
		
		
	}

}

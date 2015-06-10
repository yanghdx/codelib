package com.wd.utils;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;

public class UUIDHelper {

	private UUIDHelper(){}
	
	/**
	 * 生成uuid（guid）
	 * @author yang_huidi
	 * @return  
	 */
	
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		s = StringUtils.replace(s, "-", "");
		return s;
	}
	
	public static void main(String[] args) {
		String id = UUIDHelper.getUUID();
		System.out.println(id);
		System.out.println("盐值："+id+"    "+id.length());
		String pass = "123456";
		System.out.println(MD5Helper.MD5(pass+id));
	}
}

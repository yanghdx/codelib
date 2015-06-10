package com.wd.datastruct.xml;

import org.apache.commons.lang.StringUtils;

public class XmlCharsUtil {

	private XmlCharsUtil() {
		
	}
	
	
	/**
	 * encode
	 * @author yang_huidi
	 * @param str
	 * @return  
	 */
	
	public static String encode(String str) {
		if (StringUtils.isBlank(str)) {
			return "";
		}
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll("\"", "&quot;");
		str = str.replaceAll("\'", "&apos;");
		return str;
	}
	
	
	/**
	 * decode
	 * @author yang_huidi
	 * @param str
	 * @return  
	 */
	
	public static String decode(String str) {
		if (StringUtils.isBlank(str)) {
			return "";
		}
		str = str.replaceAll("&gt;", ">");
		str = str.replaceAll("&lt;", "<");
		str = str.replaceAll("&quot;", "\"");
		str = str.replaceAll("&apos;", "\'");
		str = str.replaceAll("&amp;", "&");
		return str;
	}
}

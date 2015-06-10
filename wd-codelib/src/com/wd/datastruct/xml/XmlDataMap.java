package com.wd.datastruct.xml;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * xml组装数据
 * @author  yang_huidi
 * @version 1.00
 * @date    2014年8月6日
 * @see        
 * 
 */
public class XmlDataMap {

	//响应结果和消息
	public static final String ACTION_RESULT = "ActionResult";
	
	public static final String ACTION_MESSAGE= "ActionMessage";
	
	//功能模块
	private String cmd;
	//属性值
	private Map<String, String> propertyMap = new LinkedHashMap<String, String>();
	//行数据
	private List<XmlDataMap> rowsList = new ArrayList<XmlDataMap>();
	//绑定数据
	private Object bindData = null;
	
	/**
	 * 默认构造方法
	 */
	public XmlDataMap() {
		super();
	}
	
	/**   
	 * 带有cmd命令的构造方法
	 * @param cmd   
	 */
	public XmlDataMap(String cmd) {
		this.cmd = cmd;
	}
	
	/**   
	 * 带有结果和消息的构造方法 
	 * @param 结果成功或失败
	 * @param 提示消息   
	 */
	public XmlDataMap(boolean result, String message) {
		propertyMap.put(ACTION_RESULT, result ? "YES" : "NO");
		message = XmlCharsUtil.encode(message);
		propertyMap.put(ACTION_MESSAGE, message);
	}
	
	
	public String getCmd() {
		return this.cmd;
	}
	
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	
	/**
	 * 设置响应结果
	 * @author yang_huidi
	 * @param result  
	 */
	
	public void setActionResult(boolean result) {
		propertyMap.put(ACTION_RESULT, result ? "YES" : "NO");
	}
	/**
	 * 设置响应结果
	 * @author yang_huidi
	 * @param result  
	 */
	
	public void setActionResult(String result) {
		result = XmlCharsUtil.encode(result);
		propertyMap.put(ACTION_RESULT, result);
	}
	/**
	 * 设置响应消息
	 * @author yang_huidi
	 * @param message  
	 */
	
	public void setActionMessage(String message) {
		message = XmlCharsUtil.encode(message);
		propertyMap.put(ACTION_MESSAGE, message);
	}
	
	
	/**
	 * 获取响应结果
	 * @author yang_huidi
	 * @return  
	 */
	
	public String getActionResult() {
		return propertyMap.get(ACTION_RESULT);
	}
	
	/**
	 * 获取响应消息
	 * @author yang_huidi
	 * @return  
	 */
	
	public String getActionMessage() {
		return propertyMap.get(ACTION_MESSAGE);
	}
	
	/**
	 * 获取属性值
	 * @author yang_huidi
	 * @param key
	 * @return  
	 */
	
	public String getProperty(String key) {
		return propertyMap.get(key);
	}
	/**
	 * 设置属性值
	 * @author yang_huidi
	 * @param key
	 * @param value  
	 */
	
	public void setProperty(String key, String value) {
		key = XmlCharsUtil.encode(key);
		value = XmlCharsUtil.encode(value);
		propertyMap.put(key, value);
	}
	
	/**
	 * 添加一行记录
	 * @author yang_huidi
	 * @param dataMap  
	 */
	
	public void addRow(XmlDataMap dataMap) {
		if (dataMap != null) {
			rowsList.add(dataMap);
		}
	}
	
	
	/**
	 * 获取属性值map
	 * @author yang_huidi
	 * @return  
	 */
	
	public Map<String, String> getPropertyMap() {
		return this.propertyMap;
	}
	/**
	 * 返回所有行数据
	 * @author yang_huidi
	 * @return  
	 */
	
	public List<XmlDataMap> getRowsList() {
		return this.rowsList;
	}

	public Object getBindData() {
		return bindData;
	}

	public void setBindData(Object bindData) {
		this.bindData = bindData;
	}
	
}

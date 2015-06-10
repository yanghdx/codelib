package com.wd.datastruct.ztree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 简单ztree封装数据
 * @author yanghdx
 *
 */
public class SimpleZTreeJsonHelper implements IZTreeHelper {

	/** 所有item数据  */
	private List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
	/** 当前item  */
	private Map<String, Object> currentItem = null;
	
	
	public SimpleZTreeJsonHelper() {
		super();
	}
	
	
	/**
	 * 新增item
	 */
	public void newItem(String id, String pId, String name) {
		Map<String, Object> item = new HashMap<String, Object>();
		item.put("id", id);
		item.put("pId", pId);
		item.put("name", name);
		items.add(item);
		currentItem = item;
	}
	
	
	/**
	 * 当前item设置选中状态
	 * @param checked
	 */
	public void setChecked(boolean checked) {
		if (currentItem != null) {
			currentItem.put("checked", checked);
		}
	}
	
	/**
	 * 设置是否禁用
	 * @param disabled
	 */
	public void setChkDisabled(boolean disabled) {
		if (currentItem != null) {
			currentItem.put("chkDisabled", disabled);
		}
	}
	
	/**
	 * 当前item设置属性值
	 * @param key
	 * @param value
	 */
	public void setAttribute(String key, Object value) {
		if (StringUtils.isBlank(key)) {
			return;
		}
		if (currentItem != null) {
			currentItem.put(key, value);
		}
	}
	
	/**
	 * 获取属性值
	 * @param key
	 * @param value
	 */
	public Object getAttribute(String key) {
		if (StringUtils.isBlank(key)) {
			return null;
		}
		if (currentItem != null) {
			return currentItem.get(key);
		}
		return null;
	}
	
	
	/**
	 * 转化为json object
	 * @return
	 */
	public Object toJsonObject() {
		return items;
	}
	
	
}

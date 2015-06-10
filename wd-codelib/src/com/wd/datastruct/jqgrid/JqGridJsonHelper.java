package com.wd.datastruct.jqgrid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用来构造jqgridjson对象
 * @author yanghdx
 *
 */
public class JqGridJsonHelper {

	/** 根节点*/
	private Map<String, Object> root;
	/** 当前row */
	private Map<String, Object> currentRow;
	
	
	public JqGridJsonHelper() {
		root = new HashMap<String, Object>();
		root.put("rows", new ArrayList<Object>());
	}
	
	public JqGridJsonHelper(List<Object> rows) {
		if (rows == null) {
			rows = new ArrayList<Object>();
		}
		root = new HashMap<String, Object>();
		root.put("rows", rows);
	}
	/**
	 * 添加新row
	 * @param id
	 */
	@SuppressWarnings("unchecked")
	public void newRow(String id) {
		List<Object> rows = (List<Object>)root.get("rows");
		Map<String, Object> row = new HashMap<String, Object>();
		row.put("id", id);
		row.put("cell", new ArrayList<Object>());
		rows.add(row);
		
		currentRow = row;
	}
	/**
	 * 在新增的row里面添加字段
	 * @param data
	 */
	@SuppressWarnings("unchecked")
	public void addCell(Object data) {
		if (currentRow == null) {
			currentRow = new HashMap<String, Object>();
			currentRow.put("id", String.valueOf(System.currentTimeMillis()));
			currentRow.put("cell", new ArrayList<Object>());
		}
		List<Object> cell = (List<Object>)currentRow.get("cell");
		cell.add(data);
		currentRow.put("cell", cell);
	}
	/**
	 * 设置页码
	 * @param page
	 */
	public void setPage(int page) {
		root.put("page", page);
	}
	/**
	 * 设置总页数
	 * @param total
	 */
	public void setTotal(int total) {
		root.put("total", total);
	}
	/**
	 * 设置总记录数
	 * @param records
	 */
	public void setRecords(int records) {
		root.put("records", records);
	}
	
	/**
	 * 获取grid map对象
	 * @return
	 */
	public Object toJsonObject() {
		return root;
	}
	
}

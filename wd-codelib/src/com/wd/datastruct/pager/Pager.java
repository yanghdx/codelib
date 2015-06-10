package com.wd.datastruct.pager;

import java.util.List;

public class Pager {

	//总记录数
	private int totalRows = 0;
	//总页数
	private int totalPages = 0;
	//每页记录数
	private int pageSize = 0;
	//当前第几页
	private int currentPage = 0;
	
	//一页数据
	private List<?> rows = null;
	
	public Pager() {
		super();
	}
	
	
	public List<?> getRows() {
		return rows;
	}


	public long getTotalRows() {
		return totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	
	/**
	 * 获取数据起始序号
	 * @return
	 */
	public int getStart() {
		int start = (this.currentPage-1) * this.pageSize;
		return start >= 0 ? start : 0;
	}
	
	/**
	 * 构建pager
	 */
	public Pager normalize() {
		if (this.rows == null || this.rows.size() == 0) {
			return this;
		}
		if (this.totalRows < 0) {
			throw new IllegalArgumentException("Pager->totalCount should be a postive number");
		}
		if (this.currentPage <= 0) {
			throw new IllegalArgumentException("Pager->currentPageNumber should be a postive number");
		}
		if (this.pageSize <= 0) {
			throw new IllegalArgumentException("Pager->perPageNumber should be a postive number");
		}
		if (this.totalRows <= this.pageSize) {
			this.totalPages = 1;
		} else {
			this.totalPages = this.totalRows / this.pageSize;
			if (this.totalRows % this.pageSize > 0) {
				this.totalPages++;
			} 
		}
		return this;
	}
	
}

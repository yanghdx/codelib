package com.wd.datastruct.pager;

import java.util.List;

public class PagerBuilder {

	private PagerBuilder() {
		super();
	}
	/**
	 * 生成分页pager帮助类
	 * @param currentPageNumber
	 * @param perPageNumber
	 * @param dataList
	 * @param totalCount
	 * @return Pager
	 */
	public static Pager buildPager(int currentPage, int pageSize, List<?> rows, int totalRows) {
		if (totalRows < 0) {
			throw new IllegalArgumentException("Pager->totalCount should be a postive number");
		}
		if (currentPage <= 0) {
			throw new IllegalArgumentException("Pager->currentPageNumber should be a postive number");
		}
		if (pageSize <= 0) {
			throw new IllegalArgumentException("Pager->perPageNumber should be a postive number");
		}
		Pager pager = new Pager();
		pager.setCurrentPage(currentPage);
		pager.setPageSize(pageSize);
		pager.setRows(rows);
		pager.setTotalRows(totalRows);
		return pager.normalize();
	}
}

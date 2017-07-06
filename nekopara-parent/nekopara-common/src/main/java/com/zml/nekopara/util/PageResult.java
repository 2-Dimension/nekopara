package com.zml.nekopara.util;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


/**
 * 分页对象
 * @author maylor
 *
 */
@Getter
@Setter
public class PageResult<T> {
	private List<T> listData;
	private Integer currentPage=1;
	private Integer pageSize=5;
	private Integer totalCount;
	private Integer nextPage;
	private Integer prePage;
	private Integer totalPage;
	/**
	 * 空结果集
	 * @param pageSize
	 * @return
	 */
	public static PageResult emptyPageResult(Integer pageSize){
		PageResult pageResult=new PageResult(1,pageSize,new ArrayList<>());
		pageResult.setTotalPage(1);
		return pageResult;
	}
	
	public PageResult(List<T> listData, Integer currentPage, Integer pageSize,
			Integer totalCount) {
		this.listData=listData;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		this.nextPage = currentPage+1>totalPage?currentPage:currentPage+1;
		this.prePage = currentPage-1<1?currentPage:currentPage-1;
	}

	public PageResult(Integer currentPage, Integer pageSize,
			List listData) {
		this.currentPage=currentPage;
		this.pageSize=pageSize;
		this.listData=listData;
	}
	
}

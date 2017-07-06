package com.zml.nekopara.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryObject {

	private int currentPage=1;	//当前页
	private int pageSize=5;		//每页记录数
	
	private int order=0;		//order为0正序,order倒序
	public int getStart(){
		return (currentPage-1)*pageSize;
	}
	
}

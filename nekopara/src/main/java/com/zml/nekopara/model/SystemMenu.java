package com.zml.nekopara.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.apache.ibatis.type.Alias;
/**
 * 系统菜单
 * @author maylor
 *
 */
@Getter
@Setter
@Alias("SystemMenu")
public class SystemMenu extends BaseDomain{
	
	private String name;		//系统菜单名称
	private String actionUrl;	//系统菜单url
	private String intro;		//介绍
	private Long parent;	//父级菜单
	private int type;			//菜单类型0,前台,1后台
	private boolean indexShow;		//是否首页显示
	private List<Article> articleList;
}


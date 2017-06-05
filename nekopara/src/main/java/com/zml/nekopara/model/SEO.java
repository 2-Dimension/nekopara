package com.zml.nekopara.model;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

/**
 * seo优化
 * @author maylor
 *
 */
@Getter
@Setter
@Alias("SEO")
public class SEO{

	public static final int SEO_TYPE_INDEX=0;
	public static final int SEO_TYPE_SYSTEMMENU=1;
	public static final int SEO_TYPE_ARTICLE=2;
	private Long seoId;			
	private String seoTitle;			//页面标题
	private String seoDescription;		//页面描述
	private String seoKeywords;			//页面关键字
	private int seoType;	//0首页1一级菜单2文章
	private Long seoAsid;	//关联的对象的id
	
}

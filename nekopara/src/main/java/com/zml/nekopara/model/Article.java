package com.zml.nekopara.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;
/**
 * 文章
 * @author maylor
 *
 */
@Getter
@Setter
@Alias("Article")
public class Article extends BaseDomain{
	
	private String title;		//文章标题
	private String content;		//文章内容
	private Integer pageView=0;	//浏览量
	private Long editorId;		//小编
	private String image;		//图片
	private String intro;		//简介
	private Date createTime;	//创建时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date publishTime;	//发布时间
	private Boolean isPublish;	//是否发布
	private Boolean isTop;		//是否置顶
	private String authorName;	//作者名称
	private String source;		//来源
	private String sourceUrl;	//来源url
	private SystemMenu systemMenu;	//文章所属菜单
	private List<Tag> tagList;		//标签
	private Integer sequence;		//排序

	public String getSourceDisplay(){
		return StringUtils.hasLength(source)?source:"原创";
	}
	
	public String getPublishTimeDisplay(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
		return sdf.format(publishTime);
	}
	
}

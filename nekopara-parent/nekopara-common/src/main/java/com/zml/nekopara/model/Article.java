package com.zml.nekopara.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 文章
 * @author maylor
 *
 */
@Getter
@Setter
@Alias("Article")
@ApiModel("文章实体类")
public class Article extends BaseDomain{
	@ApiModelProperty("文章标题")
	private String title;		//文章标题
	@ApiModelProperty("文章内容")
	private String content;		//文章内容
	@ApiModelProperty("浏览量")
	private Integer pageView=0;	//浏览量
	@ApiModelProperty("小编")
	private Long editorId;		//小编
	@ApiModelProperty("图片")
	private String image;		//图片
	@ApiModelProperty("简介")
	private String intro;		//简介
	@ApiModelProperty("创建时间")
	private Date createTime;	//创建时间
	@ApiModelProperty("发布时间")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date publishTime;	//发布时间
	@ApiModelProperty("是否发布")
	private Boolean isPublish;	//是否发布
	@ApiModelProperty("是否置顶")
	private Boolean isTop;		//是否置顶
	@ApiModelProperty("作者名称")
	private String authorName;	//作者名称
	@ApiModelProperty("来源")
	private String source;		//来源
	@ApiModelProperty("来源url")
	private String sourceUrl;	//来源url
	@ApiModelProperty("文章所属菜单")
	private SystemMenu systemMenu;	//文章所属菜单
	@ApiModelProperty("标签")
	private List<Tag> tagList;		//标签
	@ApiModelProperty("排序")
	private Integer sequence;		//排序

	public String getSourceDisplay(){
		return StringUtils.hasLength(source)?source:"原创";
	}
	
	public String getPublishTimeDisplay(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
		return sdf.format(publishTime);
	}
	
}

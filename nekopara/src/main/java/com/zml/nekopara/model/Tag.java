package com.zml.nekopara.model;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

/**
 * 文章标签
 * @author maylor
 *
 */
@Alias("Tag")
@Getter
@Setter
public class Tag extends BaseDomain{
	
	private String tagname;		//标签名称
	private int num;			//文章数
	private int click;			//点击数
	
}

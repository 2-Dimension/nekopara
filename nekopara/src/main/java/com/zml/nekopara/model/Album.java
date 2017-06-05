package com.zml.nekopara.model;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

/**
 * 相册
 * @author maylor
 *
 */
@Getter
@Setter
@Alias("Album")
public class Album extends BaseDomain{
	private String name;
	private String image;
	private String url;

}

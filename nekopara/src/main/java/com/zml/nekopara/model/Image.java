package com.zml.nekopara.model;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
/**
 * 图像类
 * @author zhumeilu
 *
 */
@Getter
@Setter
@Alias("Image")
public class Image extends BaseDomain {

	private String image;
	private String defaultImage;
	private String url;
	private String title;
	private String intro;
}

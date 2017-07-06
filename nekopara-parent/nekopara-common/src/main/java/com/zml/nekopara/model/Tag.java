package com.zml.nekopara.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

/**
 * 文章标签
 * @author maylor
 *
 */
@Alias("Tag")
@Getter
@Setter
@ApiModel("标签实体类")
public class Tag extends BaseDomain{
	@ApiModelProperty("标签名称")
	private String tagname;		//标签名称
	@ApiModelProperty("文章数")
	private int num;			//文章数
	@ApiModelProperty("点击数")
	private int click;			//点击数
	
}

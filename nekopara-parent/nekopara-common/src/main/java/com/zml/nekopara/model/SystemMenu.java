package com.zml.nekopara.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("系统菜单实体类")
public class SystemMenu extends BaseDomain{
	@ApiModelProperty("系统菜单名称")
	private String name;		//系统菜单名称
	@ApiModelProperty("系统菜单url")
	private String actionUrl;	//系统菜单url
	@ApiModelProperty("介绍")
	private String intro;		//介绍
	@ApiModelProperty("父级菜单")
	private Long parent;	//父级菜单
	@ApiModelProperty("菜单类型0,前台,1后台")
	private int type;			//菜单类型0,前台,1后台
	@ApiModelProperty("是否首页显示")
	private boolean indexShow;		//是否首页显示
}


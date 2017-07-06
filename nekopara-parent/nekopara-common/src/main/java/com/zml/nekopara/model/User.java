package com.zml.nekopara.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

/**
 * 用户
 * @author maylor
 *
 */
@Getter
@Setter
@Alias("User")
@ToString
@ApiModel("用户实体类")
public class User extends BaseDomain{

	@ApiModelProperty("用户名")
	private String username;		//用户名
	@ApiModelProperty("用户密码")
	private String password;		//用户密码
	@ApiModelProperty("用户名称")
	private String name;			//用户昵称
	
}

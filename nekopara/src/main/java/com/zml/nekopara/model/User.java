package com.zml.nekopara.model;

import org.apache.ibatis.type.Alias;

import lombok.Setter;

import lombok.Getter;

/**
 * 用户
 * @author maylor
 *
 */
@Getter
@Setter
@Alias("User")
public class User extends BaseDomain{

	
	private String username;		//用户名
	private String password;		//用户密码
	private String name;			//用户昵称
	
}

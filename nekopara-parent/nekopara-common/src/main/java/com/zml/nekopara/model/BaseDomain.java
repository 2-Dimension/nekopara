package com.zml.nekopara.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BaseDomain implements Serializable{

	@ApiModelProperty("用户id")
	private Long id;
}

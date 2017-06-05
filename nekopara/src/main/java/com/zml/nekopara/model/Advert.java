package com.zml.nekopara.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * 广告
 * @author maylor
 *
 */
@Getter
@Setter
@Alias("Advert")
public class Advert extends BaseDomain{

	private String name;			//名称
	private String image;		//广告图片
	private Long advertPositionId;		//广告位
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private	Date beginDate;		//开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;		//结束时间
	private String url;			//广告地址
}

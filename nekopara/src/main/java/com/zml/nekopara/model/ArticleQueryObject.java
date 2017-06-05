package com.zml.nekopara.model;

import java.util.Date;

import com.zml.nekopara.util.DateUtil;
import com.zml.nekopara.util.QueryObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleQueryObject extends QueryObject {
	private Long systemMenuId; // 菜单id
	private Integer level = 1; // 菜单等级
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date beginDate; // 开始时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate; // 结束时间
	private String keywords; // 关键字
	private String orderBy; // 排序
	private String orderType="desc";	//排序类型 正序,逆序
	private Boolean isTop; // 是否置顶
	private Long tagid;		//标签id

	public String getKeywords() {
		return StringUtils.hasLength(this.keywords) ? this.keywords : null;
	}

	public Date getEndDate() {
		return this.endDate != null ? DateUtil.endOfDay(this.endDate) : null;
	}

	public String getOrderBy() {
		return StringUtils.hasLength(orderBy) ? orderBy : null;
	}
	public String getOrderType(){
		return StringUtils.hasLength(orderType)? orderType : null;
	}

	
}

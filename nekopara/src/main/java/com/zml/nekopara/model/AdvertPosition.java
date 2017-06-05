package com.zml.nekopara.model;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

/**
 * 广告位
 * 
 * @author maylor
 * 
 */
@Getter
@Setter
@Alias("AdvertPosition")
public class AdvertPosition extends BaseDomain {

	private String name; // 广告位名称
	private boolean statue; // 状态
	private int type; // 0单图片,1多图片随机展示,2 轮播图
	private Integer width; // 宽度
	private Integer height; // 高度

	public String getTypeDisplay() {
		switch (type) {
		case 0:
			return "单图片";
		case 1:
			return "多图片随机展示";
		case 2:
			return "轮播图";
		default:
			return "参数异常";
		}
	}

	public String getStatueDisplay() {
		return statue == true ? "开启" : "关闭";
	}
}

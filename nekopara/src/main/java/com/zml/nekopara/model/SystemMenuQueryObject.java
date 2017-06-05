package com.zml.nekopara.model;

import com.zml.nekopara.util.QueryObject;
import lombok.Getter;
import lombok.Setter;

/**
 * 菜单查询对象
 * @author maylor
 *
 */
@Getter
@Setter
public class SystemMenuQueryObject extends QueryObject {

	private Boolean indexShow;
}

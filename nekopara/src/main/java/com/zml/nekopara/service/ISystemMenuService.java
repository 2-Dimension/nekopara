package com.zml.nekopara.service;

import com.zml.nekopara.model.SystemMenu;
import com.zml.nekopara.model.SystemMenuQueryObject;

import java.util.List;


/**
 * 系统菜单
 * @author maylor
 *
 */
public interface ISystemMenuService {

	void save(SystemMenu systemMenu);
	void delete(Long id);
	void update(SystemMenu systemMenu);
	SystemMenu get(Long id);
	
	List<SystemMenu> list(SystemMenuQueryObject qo);
	List<SystemMenu> getFirstSystemMenu();
	List<SystemMenu> findIndexShow();
}

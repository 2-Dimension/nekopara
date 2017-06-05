package com.zml.nekopara.mapper;

import com.zml.nekopara.model.SystemMenu;
import com.zml.nekopara.model.SystemMenuQueryObject;

import java.util.List;


public interface SystemMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemMenu record);

    SystemMenu selectByPrimaryKey(Long id);

    List<SystemMenu> selectAll();

    int updateByPrimaryKey(SystemMenu record);


	List<SystemMenu> list(SystemMenuQueryObject qo);

	List<SystemMenu> getFirstSystemMenu();

	List<SystemMenu> findIndexShow();
}
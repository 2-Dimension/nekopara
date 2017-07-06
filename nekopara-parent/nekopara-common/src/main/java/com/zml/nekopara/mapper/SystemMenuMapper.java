package com.zml.nekopara.mapper;

import com.zml.nekopara.model.SystemMenu;
import com.zml.nekopara.query.SystemMenuQueryObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
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
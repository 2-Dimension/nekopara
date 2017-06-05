package com.zml.nekopara.mapper;

import com.zml.nekopara.model.Tag;
import com.zml.nekopara.util.QueryObject;

import java.util.List;


public interface TagMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Tag record);

    Tag selectByPrimaryKey(Long id);

    List<Tag> selectAll();

    int updateByPrimaryKey(Tag record);

	int queryForCount(QueryObject qo);

	List<Tag> queryForCondition(QueryObject qo);
}
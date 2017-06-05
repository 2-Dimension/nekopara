package com.zml.nekopara.mapper;

import com.zml.nekopara.model.AdvertPosition;
import com.zml.nekopara.model.Article;
import com.zml.nekopara.util.QueryObject;

import java.util.List;

public interface AdvertPositionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AdvertPosition record);

    AdvertPosition selectByPrimaryKey(Long id);

    List<AdvertPosition> selectAll();

    int updateByPrimaryKey(AdvertPosition record);

	int queryForCount(QueryObject qo);

	List<Article> queryForCondition(QueryObject qo);
}
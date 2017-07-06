package com.zml.nekopara.mapper;

import com.zml.nekopara.model.Tag;
import com.zml.nekopara.util.QueryObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TagMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Tag record);

    Tag selectByPrimaryKey(Long id);

    List<Tag> selectAll();

    int updateByPrimaryKey(Tag record);

	int queryForCount(QueryObject qo);

	List<Tag> queryForCondition(QueryObject qo);
}
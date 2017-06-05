package com.zml.nekopara.mapper;


import com.zml.nekopara.model.SEO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SEOMapper {
    int deleteByPrimaryKey(Long SEOId);

    int insert(SEO record);

    SEO selectByPrimaryKey(Long SEOId);

    List<SEO> selectAll();

    int updateByPrimaryKey(SEO record);

	SEO findByTypeAndAsid(@Param("type") int type, @Param("asid") Long asid);
}
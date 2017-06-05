package com.zml.nekopara.mapper;

import com.zml.nekopara.model.Advert;
import com.zml.nekopara.model.Article;
import com.zml.nekopara.util.QueryObject;

import java.util.List;


public interface AdvertMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Advert record);

    Advert selectByPrimaryKey(Long id);

    List<Advert> selectAll();

    int updateByPrimaryKey(Advert record);

	int queryForCount(QueryObject qo);

	List<Article> queryForCondition(QueryObject qo);

	List<Advert> findByApId(Long apid);
}
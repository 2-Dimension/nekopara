package com.zml.nekopara.service;

import com.zml.nekopara.model.Advert;
import com.zml.nekopara.util.PageResult;
import com.zml.nekopara.util.QueryObject;

import java.util.List;


public interface IAdvertService {

	void save(Advert ad);
	void delete(Long id);
	Advert get(Long id);
	void update(Advert ad);
	PageResult query(QueryObject qo);
	int queryForCount(QueryObject qo);
	List<Advert> findByApId(Long apid);
}

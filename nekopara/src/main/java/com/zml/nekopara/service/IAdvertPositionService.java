package com.zml.nekopara.service;

import com.zml.nekopara.model.AdvertPosition;
import com.zml.nekopara.util.PageResult;
import com.zml.nekopara.util.QueryObject;

import java.util.List;


public interface IAdvertPositionService {

	void save(AdvertPosition ap);
	void delete(Long id);
	AdvertPosition get(Long id);
	void update(AdvertPosition ap);
	PageResult query(QueryObject qo);
	List<AdvertPosition> findAll();
}

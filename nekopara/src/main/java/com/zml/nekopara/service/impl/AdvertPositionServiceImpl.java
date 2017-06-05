package com.zml.nekopara.service.impl;

import java.util.List;

import com.zml.nekopara.mapper.AdvertPositionMapper;
import com.zml.nekopara.model.AdvertPosition;
import com.zml.nekopara.model.Article;
import com.zml.nekopara.service.IAdvertPositionService;
import com.zml.nekopara.util.PageResult;
import com.zml.nekopara.util.QueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdvertPositionServiceImpl implements IAdvertPositionService {

	@Autowired
	private AdvertPositionMapper advertPositionMapper;
	@Override
	public void save(AdvertPosition ap) {
		advertPositionMapper.insert(ap);
	}

	@Override
	public void delete(Long id) {
		advertPositionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public AdvertPosition get(Long id) {
		return advertPositionMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(AdvertPosition ap) {
		advertPositionMapper.updateByPrimaryKey(ap);
	}

	@Override
	public PageResult query(QueryObject qo) {
		int ret=advertPositionMapper.queryForCount(qo);
		if(ret==0){
			return PageResult.emptyPageResult(qo.getPageSize());
		}
		List<Article> listData=advertPositionMapper.queryForCondition(qo);
		
		return new PageResult<>(listData, qo.getCurrentPage(), qo.getPageSize(), ret);
	}

	@Override
	public List<AdvertPosition> findAll() {
		return advertPositionMapper.selectAll();
	}

}

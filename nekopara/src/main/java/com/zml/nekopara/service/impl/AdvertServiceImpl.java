package com.zml.nekopara.service.impl;

import java.util.List;

import com.zml.nekopara.mapper.AdvertMapper;
import com.zml.nekopara.model.Advert;
import com.zml.nekopara.model.Article;
import com.zml.nekopara.service.IAdvertService;
import com.zml.nekopara.util.PageResult;
import com.zml.nekopara.util.QueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertServiceImpl implements IAdvertService {

	@Autowired
	private AdvertMapper advertMapper;
	@Override
	public void save(Advert ad) {
		advertMapper.insert(ad);
	}

	@Override
	public void delete(Long id) {
		advertMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Advert get(Long id) {
		return advertMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(Advert ad) {
		advertMapper.updateByPrimaryKey(ad);
	}

	@Override
	public PageResult query(QueryObject qo) {
		int ret=advertMapper.queryForCount(qo);
		if(ret==0){
			return PageResult.emptyPageResult(qo.getPageSize());
		}
		List<Article> listData=advertMapper.queryForCondition(qo);
		
		return new PageResult<>(listData, qo.getCurrentPage(), qo.getPageSize(), ret);
	}

	@Override
	public int queryForCount(QueryObject qo) {
		return advertMapper.queryForCount(qo);
	}

	@Override
	public List<Advert> findByApId(Long apid) {
		return advertMapper.findByApId(apid);
	}

	
}

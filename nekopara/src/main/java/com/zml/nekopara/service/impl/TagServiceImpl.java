package com.zml.nekopara.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user5u.myweb.domain.Article;
import com.user5u.myweb.domain.Tag;
import com.user5u.myweb.mapper.TagMapper;
import com.user5u.myweb.service.ITagService;
import com.user5u.myweb.util.PageResult;
import com.user5u.myweb.util.QueryObject;
@Service
public class TagServiceImpl implements ITagService {

	@Autowired
	private TagMapper tagMapper;
	
	
	@Override
	public void save(Tag tag) {
		tagMapper.insert(tag);
	}

	@Override
	public void delete(Long id) {
		tagMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Tag get(Long id) {
		return tagMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(Tag tag) {
		tagMapper.updateByPrimaryKey(tag);
	}

	@Override
	public PageResult query(QueryObject qo) {
		int ret=tagMapper.queryForCount(qo);
		if(ret==0){
			return PageResult.emptyPageResult(qo.getPageSize());
		}
		List<Tag> listData=tagMapper.queryForCondition(qo);
		
		return new PageResult<>(listData, qo.getCurrentPage(), qo.getPageSize(), ret);
	}

	@Override
	public List<Tag> listAll() {
		return tagMapper.selectAll();
	}

}

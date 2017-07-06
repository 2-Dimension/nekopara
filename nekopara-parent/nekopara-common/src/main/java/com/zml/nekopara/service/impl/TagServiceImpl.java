package com.zml.nekopara.service.impl;

import com.zml.nekopara.mapper.TagMapper;
import com.zml.nekopara.model.Tag;
import com.zml.nekopara.service.ITagService;
import com.zml.nekopara.util.PageResult;
import com.zml.nekopara.util.QueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

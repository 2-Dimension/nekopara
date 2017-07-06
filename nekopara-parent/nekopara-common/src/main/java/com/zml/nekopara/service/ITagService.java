package com.zml.nekopara.service;

import com.zml.nekopara.model.Tag;
import com.zml.nekopara.util.PageResult;
import com.zml.nekopara.util.QueryObject;

import java.util.List;


public interface ITagService {

	void save(Tag tag);
	void delete(Long id);
	Tag get(Long id);
	void update(Tag tag);
	PageResult query(QueryObject qo);
	List<Tag> listAll();
}

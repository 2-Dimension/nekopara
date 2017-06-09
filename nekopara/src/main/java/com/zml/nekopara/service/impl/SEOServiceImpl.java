package com.zml.nekopara.service.impl;

import com.zml.nekopara.mapper.SEOMapper;
import com.zml.nekopara.model.SEO;
import com.zml.nekopara.service.ISEOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.Setter;

/**
 * 
 * @author maylor
 *
 */
@Service
public class SEOServiceImpl implements ISEOService {

	@Autowired
	private SEOMapper seoMapper;
	
	@Override
	public void save(SEO seo) {
		seoMapper.insert(seo);
	}

	@Override
	public void delete(Long id) {
		seoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public SEO get(Long id) {
		return seoMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(SEO seo) {
		seoMapper.updateByPrimaryKey(seo);
	}

	@Override
	public SEO findByTypeAndAsid(int type, Long asid) {
		return seoMapper.findByTypeAndAsid(type,asid);
	}

	
}

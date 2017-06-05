package com.zml.nekopara.service;


import com.zml.nekopara.model.SEO;

public interface ISEOService {

	void save(SEO seo);
	void delete(Long id);
	SEO get(Long id);
	void update(SEO seo);
	SEO findByTypeAndAsid(int type, Long asid);
}

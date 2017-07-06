package com.zml.nekopara.service.impl;

import com.zml.nekopara.mapper.ArticleMapper;
import com.zml.nekopara.mapper.SystemMenuMapper;
import com.zml.nekopara.model.Article;
import com.zml.nekopara.model.SystemMenu;
import com.zml.nekopara.query.ArticleQueryObject;
import com.zml.nekopara.query.SystemMenuQueryObject;
import com.zml.nekopara.service.ISystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemMenuServiceImpl implements ISystemMenuService {

	@Autowired
	private SystemMenuMapper systemMenuMapper;
	@Autowired
	private ArticleMapper articleMapper;
	@Override
	public void save(SystemMenu systemMenu) {
		systemMenuMapper.insert(systemMenu);
	}

	@Override
	public void delete(Long id) {
		systemMenuMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(SystemMenu systemMenu) {
		systemMenuMapper.updateByPrimaryKey(systemMenu);
	}

	@Override
	public SystemMenu get(Long id) {
		return systemMenuMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public List<SystemMenu> list(SystemMenuQueryObject qo) {
		return systemMenuMapper.list(qo);
	}

	@Override
	public List<SystemMenu> getFirstSystemMenu() {
		
		return systemMenuMapper.getFirstSystemMenu();
	}

}

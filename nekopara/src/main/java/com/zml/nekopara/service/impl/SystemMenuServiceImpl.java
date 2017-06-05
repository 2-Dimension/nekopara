package com.zml.nekopara.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user5u.myweb.domain.Article;
import com.user5u.myweb.domain.ArticleQueryObject;
import com.user5u.myweb.domain.SystemMenu;
import com.user5u.myweb.domain.SystemMenuQueryObject;
import com.user5u.myweb.mapper.ArticleMapper;
import com.user5u.myweb.mapper.SystemMenuMapper;
import com.user5u.myweb.service.ISystemMenuService;
import com.user5u.myweb.util.QueryObject;
@Service
public class SystemMenuServiceImpl implements ISystemMenuService{

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

	@Override
	public List<SystemMenu> findIndexShow() {
		SystemMenuQueryObject qo=new SystemMenuQueryObject();
		qo.setIndexShow(true);
		List<SystemMenu> findIndexShow = systemMenuMapper.list(qo);
		ArticleQueryObject qo2=new ArticleQueryObject();
		qo2.setPageSize(4);
		if(findIndexShow.size()>0){
			for (SystemMenu systemMenu : findIndexShow) {
				qo2.setSystemMenuId(systemMenu.getId());
				List<Article> queryForCondition = articleMapper.queryForCondition(qo2);
				systemMenu.setArticleList(queryForCondition);
			}
		}
		return findIndexShow;
	}

}

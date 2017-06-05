package com.zml.nekopara.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user5u.myweb.domain.Article;
import com.user5u.myweb.domain.ArticleQueryObject;
import com.user5u.myweb.domain.Tag;
import com.user5u.myweb.mapper.ArticleMapper;
import com.user5u.myweb.service.IArticleService;
import com.user5u.myweb.util.PageResult;
import com.user5u.myweb.util.QueryObject;

@Service
public class ArticleServiceImpl implements IArticleService{

	@Autowired
	private ArticleMapper articleMapper;
	@Override
	public void save(Article article) {
		
		article.setPageView(0);
		article.setCreateTime(new Date());
		article.setPublishTime(new Date());
		articleMapper.insert(article);
		//建立文章和标签之间的关系
		for (Tag tag : article.getTagList()) {
			articleMapper.saveRelation(article.getId(), tag.getId());
		}
	}

	@Override
	public void delete(Long id) {
		//删除文章标签关联表的数据
		articleMapper.deleteRelation(id);
		
		articleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Article> list() {
		return null;
	}

	@Override
	public Article view(Long id) {
		Article article = articleMapper.selectByPrimaryKey(id);
		article.setPageView(article.getPageView()+1);
		articleMapper.updateByPrimaryKey(article);
		return article;
	}

	@Override
	public void update(Article article) {
		//先删除,在添加
		articleMapper.deleteRelation(article.getId());
		//建立文章和标签之间的关系
		for (Tag tag : article.getTagList()) {
			articleMapper.saveRelation(article.getId(), tag.getId());
		}
		article.setPublishTime(new Date());
		articleMapper.updateByPrimaryKey(article);  
	}

	@Override
	public Article getNextArticle(Long id) {
		return articleMapper.getNextArticle(id);
	}

	@Override
	public Article getBeforeArticle(Long id) {
		return articleMapper.getBeforeArticle(id);
	}

	@Override
	public PageResult<Article> query(QueryObject qo) {
		
		int ret=articleMapper.queryForCount(qo);
		if(ret==0){
			return PageResult.emptyPageResult(qo.getPageSize());
		}
		List<Article> listData=articleMapper.queryForCondition(qo);
		
		return new PageResult<>(listData, qo.getCurrentPage(), qo.getPageSize(), ret);
	}

	@Override
	public List<Article> getHotArticle(Long id,int num) {
		ArticleQueryObject qo=new ArticleQueryObject();
		qo.setSystemMenuId(id);
		qo.setPageSize(num);
		qo.setOrderBy("pageView");
		qo.setOrderType("desc");
		return articleMapper.queryForCondition(qo);
	}

	@Override
	public List<Article> getNewArticle(Long id,int num) {
		ArticleQueryObject qo=new ArticleQueryObject();
		qo.setSystemMenuId(id);
		qo.setPageSize(num);
		qo.setOrderBy("publishTime");
		qo.setOrderType("desc");
		return articleMapper.queryForCondition(qo);
	}

	@Override
	public Article get(Long id) {
		return articleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Article> getTopArticle(Long id,int num) {
		ArticleQueryObject qo=new ArticleQueryObject();
		qo.setSystemMenuId(id);
		qo.setPageSize(num);
		qo.setIsTop(true);
		qo.setOrderBy("publishTime");
		qo.setOrderType("desc");
		return articleMapper.queryForCondition(qo);
	}

	@Override
	public PageResult<Article> findArticleByTag(ArticleQueryObject qo) {
		int ret=articleMapper.selectCountByTag(qo.getTagid());
		if(ret==0){
			return PageResult.emptyPageResult(qo.getPageSize());
		}
		List<Article> listData=articleMapper.selectArticleByTag(qo.getTagid());
		
		return new PageResult<>(listData, qo.getCurrentPage(), qo.getPageSize(), ret);
	}

}

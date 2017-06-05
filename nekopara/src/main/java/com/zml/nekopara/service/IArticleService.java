package com.zml.nekopara.service;

import com.zml.nekopara.model.Article;
import com.zml.nekopara.model.ArticleQueryObject;
import com.zml.nekopara.util.PageResult;
import com.zml.nekopara.util.QueryObject;

import java.util.List;


/**
 * 文章业务类
 * @author maylor
 *
 */
public interface IArticleService {

	void save(Article article);
	void delete(Long id);
	Article view(Long id);
	Article get(Long id);
	void update(Article article);
	List<Article> list();
	/**
	 * 高级查询
	 * @param qo
	 * @return
	 */
	PageResult<Article> query(QueryObject qo);
	
	/**
	 * 上一篇文章
	 * @param id
	 * @return
	 */
	Article getNextArticle(Long id);
	/**
	 * 下一篇文章
	 * @param id
	 * @return
	 */
	Article getBeforeArticle(Long id);
	List<Article> getHotArticle(Long id, int num);
	List<Article> getNewArticle(Long id, int num);
	List<Article> getTopArticle(Long id, int num);
	PageResult<Article> findArticleByTag(ArticleQueryObject qo);
}

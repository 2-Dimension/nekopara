package com.zml.nekopara.mapper;

import java.util.List;

import com.zml.nekopara.model.Article;
import com.zml.nekopara.util.QueryObject;
import org.apache.ibatis.annotations.Param;


public interface ArticleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    Article selectByPrimaryKey(Long id);

    List<Article> selectAll();

    int updateByPrimaryKey(Article record);

	int queryForCount(QueryObject qo);

	List<Article> queryForCondition(QueryObject qo);

	Article getNextArticle(@Param("id") Long id);

	Article getBeforeArticle(@Param("id") Long id);

	List<Article> getHotArticle(@Param("id") Long id, @Param("num") int num);

	List<Article> getNewArticle(@Param("id") Long id, @Param("num") int num);

	List<Article> getTopArticle(@Param("id") Long id, @Param("num") int num);
	
	int saveRelation(@Param("articleid") Long articleid, @Param("tagid") Long tagid);
	
	int deleteRelation(Long articleid);

	int selectCountByTag(Long tagid);

	List<Article> selectArticleByTag(Long tagid);
}
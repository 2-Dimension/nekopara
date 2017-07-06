package com.zml.nekopara.controller;

import com.alibaba.fastjson.JSONObject;
import com.zml.nekopara.model.Article;
import com.zml.nekopara.query.ArticleQueryObject;
import com.zml.nekopara.service.IArticleService;
import com.zml.nekopara.service.ISystemMenuService;
import com.zml.nekopara.service.ITagService;
import com.zml.nekopara.util.AjaxResult;
import com.zml.nekopara.util.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value = "文章管理",description="文章列表，文章增删改查")
@Controller
@RequestMapping(value = "/v1/admin/articles")
public class ArticleController extends CommonController{

	@Autowired
	private IArticleService articleService;
	@Autowired
	private ISystemMenuService systemMenuService;
	@Autowired
	private ITagService tagService;

	/**
	 * 添加article
	 * @param article
	 * @return
	 */
	@ApiOperation("添加article")
	@RequestMapping(value = "",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult add(Article article){
		articleService.save(article);
		return new AjaxResult(true,"添加成功");
	}


	/**
	 * 编辑文章
	 * @param id
	 * @param article
	 * @return
	 */
	@ApiOperation("编辑文章")
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	@ResponseBody
	public AjaxResult edit(@PathVariable Long id, Article article){
		articleService.update(article);
		return new AjaxResult(true,"编辑成功");
	}

	/**
	 * 根据id获取文章
	 * @param id
	 * @return
	 */
	@ApiOperation("根据id获取文章")
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Article get(@PathVariable Long id){
		return articleService.get(id);
	}

	/**
	 * 删除文章
	 * @param id
	 * @return
	 */
	@ApiOperation("删除文章")
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public AjaxResult delete(@PathVariable Long id){
		articleService.delete(id);
		return new AjaxResult(true,"删除成功");
	}


	/**
	 * 文章列表
	 * @param qo
	 * @param model
	 * @return
	 */
	@ApiOperation("用户列表")
	@RequestMapping(value = "",method = RequestMethod.GET)
	public JSONObject list(ArticleQueryObject qo, Model model){
		
		PageResult<Article> pageResult=articleService.query(qo);
		JSONObject json = new JSONObject();
		json.put("result",pageResult);
		json.put("qo",qo);
		return json;
	}

	/********************页面*****************************

	/**
	 * 进入article列表页面
	 * @return
	 */
	@ApiOperation("进入article列表页面")
	@RequestMapping(value = "/articles_view",method = RequestMethod.GET)
	public String articleView() {
		return "articles_view";
	}

}

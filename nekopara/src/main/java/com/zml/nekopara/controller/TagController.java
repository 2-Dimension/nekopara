package com.zml.nekopara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.user5u.myweb.domain.Article;
import com.user5u.myweb.domain.ArticleQueryObject;
import com.user5u.myweb.domain.SEO;
import com.user5u.myweb.domain.Tag;
import com.user5u.myweb.service.IArticleService;
import com.user5u.myweb.service.ITagService;
import com.user5u.myweb.util.PageResult;
import com.user5u.myweb.util.QueryObject;

@Controller
public class TagController {

	@Autowired
	private ITagService tagService;
	@Autowired
	private IArticleService articleService;
	/**
	 * =============================后台==================================
	 */
	
	@RequestMapping("/findArticleByTag")
	public String findArticleByTag(ArticleQueryObject qo,Model model){
		PageResult pageResult = articleService.findArticleByTag(qo);
		model.addAttribute("pageResult",pageResult);
		model.addAttribute("qo",qo);
		//查询最新文章,最热文章,置顶(推荐)文章
		List<Article> topArticleList = articleService.getTopArticle(qo.getSystemMenuId(),6);
		List<Article> hotArticleList = articleService.getHotArticle(qo.getSystemMenuId(),3);
		List<Article> newArticleList = articleService.getNewArticle(qo.getSystemMenuId(),5);
		model.addAttribute("topArticleList",topArticleList);
		model.addAttribute("hotArticleList",hotArticleList);
		model.addAttribute("newArticleList",newArticleList);
		return "tagArticleList";
	}
	
	
	/**
	 * 编辑页面
	 * @return
	 */
	@RequestMapping("/admin/tagEditPage")
	public String tagEditPage(Long id,String cmd,Model model){
		if(id!=null){
			if("edit".equals(cmd)){
				Tag tag = tagService.get(id);
				model.addAttribute("tag",tag);
			}
		}
		model.addAttribute("cmd",cmd);
		return "/admin/tagEdit";
	}
	
	/**
	 * 保存或者更新
	 * @param tag
	 * @param cmd
	 * @return
	 */
	@RequestMapping("/admin/tagEdit")
	public String tagEdit(Tag tag,SEO seo,String cmd,MultipartFile file,String tags){
		//编辑
		if("edit".equals(cmd)){
			//如果没有上传图片就不修改原来的图片
			tagService.update(tag);
			//保存
		}else if("save".equals(cmd)){
			tagService.save(tag);
			
		}
		return "redirect:/admin/tagList.do";
	} 
	@RequestMapping("/admin/tagDelete")
	public String tagDelete(Long id){
		tagService.delete(id);
		return "redirect:/admin/tagList.do";
	}
	/**
	 * 高级查询,分页
	 * @param qo
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/tagList")
	public String adminQuery(QueryObject qo,Model model){
		
		PageResult<Tag> pageResult=tagService.query(qo);
		model.addAttribute("pageResult",pageResult);
		model.addAttribute("qo",qo);
		return "/admin/tagList";
	}
}

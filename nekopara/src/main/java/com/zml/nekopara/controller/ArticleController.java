package com.zml.nekopara.controller;

import com.alibaba.fastjson.JSONObject;
import com.zml.nekopara.model.*;
import com.zml.nekopara.service.IArticleService;
import com.zml.nekopara.service.ISEOService;
import com.zml.nekopara.service.ISystemMenuService;
import com.zml.nekopara.service.ITagService;
import com.zml.nekopara.util.PageResult;
import com.zml.nekopara.util.QiNiuImageUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/v1/article")
public class ArticleController {

	@Autowired
	private IArticleService articleService;
	@Autowired
	private ISystemMenuService systemMenuService;
	/*@Autowired
	private ISendMessageService sendMessageService;*/
	/*@Autowired
	private Destination destination;*/
	@Autowired
	private ISEOService seoService;
	@Autowired
	private ITagService tagService;
	/**
	 * 高级查询,分页
	 * @param qo
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list",method = RequestMethod.POST)
	public String query(ArticleQueryObject qo, Model model){
		
		
		if(qo.getSystemMenuId()!=null){
			model.addAttribute("currentSystemMenu",systemMenuService.get(qo.getSystemMenuId()));
			
			PageResult pageResult=articleService.query(qo);
			model.addAttribute("pageResult",pageResult);
			model.addAttribute("qo",qo);
			//查询同类型最新文章,最热文章,置顶(推荐)文章
			List<Article> topArticleList = articleService.getTopArticle(qo.getSystemMenuId(),3);
			List<Article> hotArticleList = articleService.getHotArticle(qo.getSystemMenuId(),3);
			List<Article> newArticleList = articleService.getNewArticle(qo.getSystemMenuId(),3);
			model.addAttribute("topArticleList",topArticleList);
			model.addAttribute("hotArticleList",hotArticleList);
			model.addAttribute("newArticleList",newArticleList);
			
			//查询seo信息
			SEO seo = seoService.findByTypeAndAsid(SEO.SEO_TYPE_SYSTEMMENU, qo.getSystemMenuId());
			model.addAttribute("seo",seo);
			
			//查询广告信息
		}else{
			PageResult pageResult=articleService.query(qo);
			model.addAttribute("pageResult",pageResult);
			model.addAttribute("qo",qo);
			//查询最新文章,最热文章,置顶(推荐)文章
			List<Article> topArticleList = articleService.getTopArticle(qo.getSystemMenuId(),6);
			List<Article> hotArticleList = articleService.getHotArticle(qo.getSystemMenuId(),3);
			List<Article> newArticleList = articleService.getNewArticle(qo.getSystemMenuId(),5);
			model.addAttribute("topArticleList",topArticleList);
			model.addAttribute("hotArticleList",hotArticleList);
			model.addAttribute("newArticleList",newArticleList);
		}
		return "articleList";
		
	}   
	
	
	/**
	 * 查询某一个文章
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Object article(@PathVariable Long id, Model model){
		//按id查询某一篇文章
		Article article = articleService.view(id);
		
		model.addAttribute("article",article);
		//查询上一篇文章和下一篇文章
		Article nextArticle = articleService.getNextArticle(id);
		Article beforeArticle = articleService.getBeforeArticle(id);
		model.addAttribute("nextArticle",nextArticle);
		model.addAttribute("beforeArticle",beforeArticle);
		//查询该分类下最热文章
		List<Article> hotArticleList = articleService.getHotArticle(article.getSystemMenu().getId(),4);
		//查询该分类下最新文章
		List<Article> newArticleList = articleService.getNewArticle(article.getSystemMenu().getId(),3);
		//查询该分类下的推荐文章
		List<Article> topArticleList=articleService.getTopArticle(article.getSystemMenu().getId(), 3);
		
		model.addAttribute("topArticleList",topArticleList);
		model.addAttribute("hotArticleList",hotArticleList);
		model.addAttribute("newArticleList",newArticleList);
		//查询seo信息
		SEO seo = seoService.findByTypeAndAsid(SEO.SEO_TYPE_ARTICLE, id);
		model.addAttribute("seo",seo);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("article",article);
		//查询广告信息
		return jsonObject;
	}
	/**
	 * =============================后台==================================
	 */
	
	/**
	 * 编辑页面
	 * @return
	 */
	@RequestMapping("/admin/articleEditPage")
	public String articleEditPage(Long id,String cmd,Model model){
		model.addAttribute("tagList",tagService.listAll());
		if(id!=null){
			if("edit".equals(cmd)){
				Article article = articleService.get(id);
				model.addAttribute("article",article);
				SEO seo = seoService.findByTypeAndAsid(SEO.SEO_TYPE_ARTICLE,id);
				model.addAttribute("seo",seo);
			}
		}
		List<SystemMenu> systemMenuList = systemMenuService.list(new SystemMenuQueryObject());
		model.addAttribute("systemMenuList",systemMenuList);
		model.addAttribute("cmd",cmd);
		return "/admin/articleEdit";
	}
	
	/**
	 * 保存或者更新
	 * @param article
	 * @param cmd
	 * @return
	 */
	@RequestMapping("/admin/articleEdit")
	public String articleEdit(Article article,SEO seo,String cmd,MultipartFile file,String tags){
		//接收标签
		String[] split = tags.split(",");
		List<Tag> tagList=new ArrayList<>();
		Tag tag=null;
		for (String string : split) {
			tag=new Tag();
			tag.setId(Long.valueOf(string));
			tagList.add(tag);
		}
		article.setTagList(tagList);
		//编辑
		if("edit".equals(cmd)){
			//如果没有上传图片就不修改原来的图片
			Article oldArticle = articleService.get(article.getId());
			if(file.isEmpty()){
				article.setImage(oldArticle.getImage());
				//修改时上传了新的 图片
			}else{
					//因为图片文件在七牛云上,可以被其他的系统引用,所以不删除原来的文件
					//上传新文件
					String uuidStr=UUID.randomUUID().toString().replace("-", "");
					String filename="upload/"+uuidStr+"."+file.getContentType().substring(file.getContentType().indexOf("/")+1);
					try {
						//将文件上传到七牛云
						new QiNiuImageUploadUtil().upload(file.getBytes(),filename);
					} catch (IOException e) {
						e.printStackTrace();
					}
					article.setImage(QiNiuImageUploadUtil.webUrlPrfix+filename);
			}
			article.setCreateTime(oldArticle.getCreateTime());
			article.setIsPublish(oldArticle.getIsPublish());
			article.setPageView(oldArticle.getPageView());
			article.setPublishTime(oldArticle.getPublishTime());
			articleService.update(article);
			//更新seo信息
			seo.setSeoAsid(article.getId());
			seo.setSeoType(SEO.SEO_TYPE_ARTICLE);
			//兼容之前没有seo的文章,新系统可以去掉判断,直接更新
			if(seo.getSeoId()==null){
				seoService.save(seo);
			}else{
				seoService.update(seo);
			}
			
			//保存
		}else if("save".equals(cmd)){
			if(!file.isEmpty()){
				
				//上传图片
				String uuidStr=UUID.randomUUID().toString().replace("-", "");
				String filename="upload/"+uuidStr+"."+file.getContentType().substring(file.getContentType().indexOf("/")+1);
				try {
					//将文件上传到七牛云
					new QiNiuImageUploadUtil().upload(file.getBytes(),filename);
				} catch (IOException e) {
					e.printStackTrace();
				}
				article.setImage(QiNiuImageUploadUtil.webUrlPrfix+filename);
			}
			articleService.save(article);
			//保存seo信息
			seo.setSeoAsid(article.getId());
			seo.setSeoType(SEO.SEO_TYPE_ARTICLE);
			seoService.save(seo);
			//主站发送消息(从站不需要发送消息)
//			sendMessageService.sendMessage(destination, JSONObject.toJSONString(article));
			
		}
		return "redirect:/admin/articleList.htm";
	} 
	
	/**
	 * 高级查询,分页
	 * @param qo
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/articleList")
	public String adminQuery(ArticleQueryObject qo,Model model){
		
		PageResult<Article> pageResult=articleService.query(qo);
		model.addAttribute("pageResult",pageResult);
		model.addAttribute("qo",qo);
		List<SystemMenu> firstSysetmMenuList = systemMenuService.getFirstSystemMenu();
		model.addAttribute("firstSysetmMenuList",firstSysetmMenuList);
		return "/admin/articleList";
	}
	
	@RequestMapping("/admin/articleDelete")
	public String articleDelete(Long id){
		articleService.delete(id);
		return "redirect:/admin/articleList.htm";
		
	}
	
}

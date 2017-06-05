package com.zml.nekopara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.user5u.myweb.domain.SEO;
import com.user5u.myweb.domain.SystemMenu;
import com.user5u.myweb.domain.SystemMenuQueryObject;
import com.user5u.myweb.service.ISEOService;
import com.user5u.myweb.service.ISystemMenuService;

/**
 * 菜单controller
 * 
 * @author maylor
 * 
 */
@Controller
public class SystemMenuController {

	@Autowired
	private ISystemMenuService systemMenuService;
	@Autowired
	private ISEOService seoService;
	
	/**
	 * 高级查询,分页
	 * @param qo
	 * @param model
	 * @return
	 */
	@RequestMapping("/systemMenuList")
	public String query(@ModelAttribute SystemMenuQueryObject qo,Model model){
		List<SystemMenu> systemMenuList=systemMenuService.list(qo);
		model.addAttribute("systemMenuList",systemMenuList);
		return "systemMenuList";
	}
	
	/**
	 * ===============后台页面==================
	 */
	
	/**
	 * 高级查询,分页
	 * @param qo
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/systemMenuList")
	public String queryAdmin(@ModelAttribute SystemMenuQueryObject qo,Model model){
		List<SystemMenu> systemMenuList=systemMenuService.list(qo);
		model.addAttribute("systemMenuList",systemMenuList);
		return "admin/systemMenuList";
	}
	
	/**
	 * 保存或者更新
	 * @param article
	 * @param cmd
	 * @return
	 */
	@RequestMapping("/admin/systemMenuEdit")
	public String articleEdit(SystemMenu systemMenu,String cmd,SEO seo){
		//更新
		if("edit".equals(cmd)){
			systemMenuService.update(systemMenu);
			//完善seo信息
			seo.setSeoAsid(systemMenu.getId());
			seo.setSeoType(SEO.SEO_TYPE_SYSTEMMENU);
			//兼容之前没有seo的菜单,新系统可以去掉判断,直接更新
			if(seo.getSeoId()==null){
				seoService.save(seo);
			}else{
				seoService.update(seo);
			}
			//添加
		}else if("save".equals(cmd)){
			systemMenuService.save(systemMenu);
			//保存seo信息
			seo.setSeoAsid(systemMenu.getId());
			seo.setSeoType(SEO.SEO_TYPE_SYSTEMMENU);
			seoService.save(seo);
		}
		
		return "redirect:/admin/systemMenuList.htm";
	}
	
	/**
	 * 编辑页面
	 * 
	 * @return
	 */
	@RequestMapping("/admin/systemMenuEditPage")
	public String systemMenuEditPage(Long id, String cmd, Model model,Long pid) {
		//编辑页面
		if (id != null) {
			if ("edit".equals(cmd)) {
				SystemMenu systemMenu= systemMenuService.get(id);
				model.addAttribute("systemMenu", systemMenu);
			}
			//添加页面
		}else{
			//如果不是一级菜单
			if(pid!=null){
				SystemMenu parent = systemMenuService.get(pid);
				model.addAttribute("parent",parent);
			}
		}
		SEO seo = seoService.findByTypeAndAsid(SEO.SEO_TYPE_SYSTEMMENU, id);
		if(seo!=null){
			model.addAttribute("seo",seo);
		}
		model.addAttribute("cmd", cmd);
		return "admin/systemMenuEdit";
	}
	/**
	 * 菜单删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/admin/systemMenuDelete")
	public String systemMenuDelete(Long id){
		systemMenuService.delete(id);
		return "redirect:/admin/systemMenuList.htm";
	}
}

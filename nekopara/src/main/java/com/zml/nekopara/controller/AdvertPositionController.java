package com.zml.nekopara.controller;

import java.util.List;

import com.zml.nekopara.model.Advert;
import com.zml.nekopara.model.AdvertPosition;
import com.zml.nekopara.model.ArticleQueryObject;
import com.zml.nekopara.model.SystemMenu;
import com.zml.nekopara.service.*;
import com.zml.nekopara.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AdvertPositionController {

	@Autowired
	private IArticleService articleService;
	@Autowired
	private ISystemMenuService systemMenuService;
	@Autowired
	private ISEOService seoService;
	@Autowired
	private IAdvertPositionService advertPositionService;
	@Autowired
	private IAdvertService advertService;
	
	
	
	/**
	 * 查询某一个广告
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/loadAdvertPosition")
	public String loadAdvertPosition(Long id,Model model){
		AdvertPosition advertPosition = advertPositionService.get(id);
		model.addAttribute("advertPosition",advertPosition);
		
		List<Advert> advertList = advertService.findByApId(id);
		//多张图片随机显示一张
		if(advertPosition.getType()==1){
			int num = (int)(1+Math.random()*(advertList.size()-1+1));
			advertList.set(0, advertList.get(num-1));
		}
		model.addAttribute("advertList",advertList);
		return "/loadAdvertPosition";
	}
	/**
	 * =============================后台==================================
	 */
	
	/**
	 * 编辑页面
	 * @return
	 */
	@RequestMapping("/admin/advertPositionEditPage")
	public String articleEditPage(Long id,String cmd,Model model){
		if(id!=null){
			if("edit".equals(cmd)){
				AdvertPosition advertPosition = advertPositionService.get(id);
				model.addAttribute("advertPosition",advertPosition);
			}
		}
		model.addAttribute("cmd",cmd);
		return "/admin/advertPositionEdit";
	}
	
	/**
	 * 保存或者更新
	 * @param article
	 * @param cmd
	 * @return
	 */
	@RequestMapping("/admin/advertPositionEdit")
	public String articleEdit(AdvertPosition advertPosition,String cmd){
		//编辑
		if("edit".equals(cmd)){
			
			advertPositionService.update(advertPosition);
			
			//保存
		}else if("save".equals(cmd)){
			advertPositionService.save(advertPosition);
			
		}
		return "redirect:/admin/advertPositionList.htm";
	} 
	
	/**
	 * 高级查询,分页
	 * @param qo
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/advertPositionList")
	public String adminQuery(ArticleQueryObject qo, Model model){
		
		PageResult<AdvertPosition> pageResult=advertPositionService.query(qo);
		model.addAttribute("pageResult",pageResult);
		model.addAttribute("qo",qo);
		List<SystemMenu> firstSysetmMenuList = systemMenuService.getFirstSystemMenu();
		model.addAttribute("firstSysetmMenuList",firstSysetmMenuList);
		return "/admin/advertPositionList";
	}
}

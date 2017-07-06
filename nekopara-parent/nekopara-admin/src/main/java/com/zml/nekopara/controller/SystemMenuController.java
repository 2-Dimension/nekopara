package com.zml.nekopara.controller;

import com.alibaba.fastjson.JSONObject;
import com.zml.nekopara.model.SystemMenu;
import com.zml.nekopara.model.Tag;
import com.zml.nekopara.query.SystemMenuQueryObject;
import com.zml.nekopara.service.ISystemMenuService;
import com.zml.nekopara.util.AjaxResult;
import com.zml.nekopara.util.PageResult;
import com.zml.nekopara.util.QueryObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 菜单controller
 * 
 * @author maylor
 * 
 */
@Api(value = "系统菜单管理",description="系统菜单列表，系统菜单增删改查")
@Controller
@RequestMapping("v1/admin/systemMenus")
public class SystemMenuController {

	@Autowired
	private ISystemMenuService systemMenuService;

	/**
	 * systemMenu列表
	 * @param qo
	 * @return
	 */
	@RequestMapping(value = "",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation("systemMenu列表")
	public Object list(@ModelAttribute SystemMenuQueryObject qo) {
		List<SystemMenu> systemMenus = systemMenuService.list(qo);
		JSONObject json = new JSONObject();
		json.put("result",systemMenus);
		json.put("qo",qo);
		return json;
	}

	/**
	 *根据id修改systemMenu
	 * @return
	 */
	@ApiOperation("根据id修改systemMenu")
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	@ResponseBody
	public Object tagEdit(@PathVariable Long id, SystemMenu systemMenu) {
		systemMenuService.update(systemMenu);
		return  new AjaxResult(true, "编辑成功");
	}

	/**
	 * 添加systemMenu
	 * @return
	 */
	@ApiOperation("添加systemMenu")
	@RequestMapping(value = "",method = RequestMethod.POST)
	@ResponseBody
	public Object tagSystemMenu(SystemMenu systemMenu) {
		systemMenuService.save(systemMenu);
		return new AjaxResult(true, "添加成功");
	}


	/**
	 * 根据id删除systemMenu
	 * @param id
	 * @return
	 */
	@ApiOperation("根据id删除systemMenu")
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public Object tagDelete(@PathVariable Long id) {
		systemMenuService.delete(id);
		return new AjaxResult(true, "删除成功");
	}

	/**
	 * 根据id获取systemMenu信息
	 * @param id
	 * @return
	 */
	@ApiOperation("根据id获取systemMenu信息")
	@RequestMapping(value = "/{id}",method=RequestMethod.GET)
	@ResponseBody
	public SystemMenu getTag(@PathVariable Long id){
		SystemMenu systemMenu = systemMenuService.get(id);
		return systemMenu;
	}


	/***************************页面跳转********************************************/
	/**
	 * 进入systemMenu列表页面
	 * @return
	 */
	@ApiOperation("进入systemMenu列表页面")
	@RequestMapping(value = "/systemMenus_view",method = RequestMethod.GET)
	public String tagsView() {
		return "systemMenus_view";
	}


}

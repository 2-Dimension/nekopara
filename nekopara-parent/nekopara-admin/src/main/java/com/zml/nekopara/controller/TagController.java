package com.zml.nekopara.controller;

import com.alibaba.fastjson.JSONObject;
import com.zml.nekopara.model.Tag;
import com.zml.nekopara.service.ITagService;
import com.zml.nekopara.util.AjaxResult;
import com.zml.nekopara.util.PageResult;
import com.zml.nekopara.util.QueryObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(value = "tag管理",description="tag列表，tag增删改查")
@Controller
@RequestMapping(value = "/v1/admin/tags")
public class TagController {

	@Autowired
	private ITagService tagService;
	/**
	 * tag列表
	 * @param qo
	 * @return
	 */
	@RequestMapping(value = "",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation("tag列表")
	public Object list(@ModelAttribute QueryObject qo) {
		PageResult pageReult = tagService.query(qo);
		JSONObject json = new JSONObject();
		json.put("result",pageReult);
		json.put("qo",qo);
		return json;
	}

	/**
	 *根据id修改tag
	 * @return
	 */
	@ApiOperation("根据id修改tag")
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	@ResponseBody
	public Object tagEdit(@PathVariable Long id, Tag tag) {
		tagService.update(tag);
		return  new AjaxResult(true, "编辑成功");
	}

	/**
	 * 添加tag
	 * @return
	 */
	@ApiOperation("添加tag")
	@RequestMapping(value = "",method = RequestMethod.POST)
	@ResponseBody
	public Object tagAdd(Tag tag) {
		tagService.save(tag);
		return new AjaxResult(true, "添加成功");
	}


	/**
	 * 根据id删除tag
	 * @param id
	 * @return
	 */
	@ApiOperation("根据id删除tag")
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public Object tagDelete(@PathVariable Long id) {
		tagService.delete(id);
		return new AjaxResult(true, "删除成功");
	}

	/**
	 * 根据id获取tag信息
	 * @param id
	 * @return
	 */
	@ApiOperation("根据id获取tag信息")
	@RequestMapping(value = "/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Tag getTag(@PathVariable Long id){
		Tag tag = tagService.get(id);
		return tag;
	}


	/***************************页面跳转********************************************/
	/**
	 * 进入tag列表页面
	 * @return
	 */
	@ApiOperation("进入tag列表页面")
	@RequestMapping(value = "/tags_view",method = RequestMethod.GET)
	public String tagsView() {
		return "tags_view";
	}


}

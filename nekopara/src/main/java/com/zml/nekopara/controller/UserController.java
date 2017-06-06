package com.zml.nekopara.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.zml.nekopara.model.User;
import com.zml.nekopara.service.IUserService;
import com.zml.nekopara.util.AjaxResult;
import com.zml.nekopara.util.QueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * 登录控制器
 * @author maylor
 *
 */
@Controller
public class UserController {

	@Autowired
	private IUserService userService;
	@RequestMapping(value="/admin/login",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult login(User user, HttpSession session){
		User currUser=userService.login(user);
		if(currUser!=null){
			session.setAttribute("USER_IN_SESSION", currUser);
			return new AjaxResult(true,"登录成功");
		}else{
			return new AjaxResult(false,"登录成功");
		}
	}
	@RequestMapping("/admin/logout")
	@ResponseBody
	public AjaxResult logout(HttpSession session){
		session.invalidate();
		return new AjaxResult(true,"退出成功");
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
	@RequestMapping("/admin/userList")
	public String queryAdmin(@ModelAttribute QueryObject qo, Model model){
		List<User> userList=userService.list(qo);
		model.addAttribute("userList",userList);
		return "admin/userList";
	}
	
	/**
	 * 保存或者更新
	 * @param article
	 * @param cmd
	 * @return
	 */
	@RequestMapping("/admin/userEdit")
	public String articleEdit(User user,String cmd){
		//更新
		if("edit".equals(cmd)){
			userService.update(user);
			//添加
		}else if("save".equals(cmd)){
			userService.regist(user);
		}
		return "redirect:/admin/userList.htm";
	}
	
	/**
	 * 编辑页面
	 * 
	 * @return
	 */
	@RequestMapping("/admin/userEditPage")
	public String userEditPage(Long id, String cmd, Model model) {
		//编辑页面
		if (id != null) {
			if ("edit".equals(cmd)) {
				User user= userService.get(id);
				model.addAttribute("user", user);
			}
			//添加页面
		}
		model.addAttribute("cmd", cmd);
		return "admin/userEdit";
	}
	/**
	 * 菜单删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/admin/userDelete")
	public String userDelete(Long id){
		userService.delete(id);
		return "redirect:/admin/userList.htm";
	}
	
}

package com.zml.nekopara.controller;

import com.alibaba.fastjson.JSONObject;
import com.zml.nekopara.model.User;
import com.zml.nekopara.query.UserQueryObject;
import com.zml.nekopara.service.IUserService;
import com.zml.nekopara.util.AjaxResult;
import com.zml.nekopara.util.QueryObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "用户管理",description="用户列表，用户增删改查")
@Controller
@RequestMapping(value = "/v1/admin/users")
public class UserController {

    @Autowired
    private IUserService userService;

    protected Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 用户列表
     * @param qo
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("用户列表")
    public Object queryAdmin(@ModelAttribute UserQueryObject qo) {
        List<User> userList = userService.list(qo);
        JSONObject json = new JSONObject();
        json.put("list",userList);
        json.put("qo",qo);
        return json;
    }

    /**
     *根据id修改用户
     * @return
     */
    @ApiOperation("根据id修改用户")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Object userEdit(@PathVariable Long id,User user) {
        userService.update(user);
        return  new AjaxResult(true, "编辑成功");
    }

    /**
     * 添加用户
     * @return
     */
    @ApiOperation("添加用户")
    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public Object userAdd(User user) {
        userService.regist(user);
        return new AjaxResult(true, "添加成功");
    }


    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @ApiOperation("根据id删除用户")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Object userDelete(@PathVariable Long id) {
        userService.delete(id);
        return new AjaxResult(true, "删除成功");
    }

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    @ApiOperation("根据id获取用户信息")
    @RequestMapping(value = "/{id}",method=RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable Long id){
       User user = userService.get(id);
       return user;
    }


    /***************************页面跳转********************************************/
    /**
     * 进入user列表页面
     * @return
     */
    @ApiOperation("进入user列表页面")
    @RequestMapping(value = "/users_view",method = RequestMethod.GET)
    public String usersView() {
        return "users_view";
    }
}

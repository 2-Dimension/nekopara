package com.zml.nekopara.controller;

import com.alibaba.fastjson.JSONObject;
import com.zml.nekopara.model.User;
import com.zml.nekopara.service.IUserService;
import com.zml.nekopara.util.AjaxResult;
import com.zml.nekopara.util.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


/**
 * 登录控制器
 *
 * @author maylor
 */
@Api(value = "登录",description="用户登录")
@Controller
@RequestMapping("/v1/admin")
public class LoginController {

    @Autowired
    private IUserService userService;

    @ApiOperation("登录页面")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginpage() {
        return "login";
    }

    @ApiOperation("登录请求")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(User user, HttpSession session) {
        User currUser = userService.login(user);
        if (currUser != null) {
            session.setAttribute(Constant.USER_IN_SESSION, currUser);
            JSONObject json = new JSONObject();
            json.put("success", Boolean.TRUE);
            json.put("msg", "登录成功");
            json.put("user", currUser);
            return json;
        } else {
            JSONObject json = new JSONObject();
            json.put("success", Boolean.FALSE);
            json.put("msg", "登录失败");
            return json;
        }
    }

    @ApiOperation("退出")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult logout(HttpSession session) {
        session.invalidate();
        return new AjaxResult(true, "退出成功");
    }

}

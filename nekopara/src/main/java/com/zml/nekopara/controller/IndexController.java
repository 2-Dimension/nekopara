package com.zml.nekopara.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
//	@Autowired
//	IUserService userService;
	
	@RequestMapping("/")
	public String index(){
		System.out.println("---------index-------------");
//		User user = new User();
//		user.setUsername("zml");
//		user.setPassword("123456");
//		userService.save(user);
		return "index";
	}
	
}

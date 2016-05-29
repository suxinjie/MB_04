package com.sue.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sue.demo.entity.User;
import com.sue.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(User user ,HttpServletRequest httpServletRequest){
		User resultUser = userService.login(user);
		if(resultUser == null){
			httpServletRequest.setAttribute("user", user);
			httpServletRequest.setAttribute("errorMsg", "用户名和密码错误");
			return "index";
		}else{
			httpServletRequest.getSession().setAttribute("currentUser", resultUser);
			return "redirect:/success.jsp";
		}
		
	}

}

package com.work.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.work.ssm.pojo.User;
import com.work.ssm.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;//获取UserService对象
	//登录页面
	@RequestMapping(value="/login")
    public String login() {
    	return "login";
    }
	
	//主页面
	@RequestMapping(value="/home")
    public String showHome() {
    	return "home";
    }
	
	//添加页面
	@RequestMapping(value="/add")
	public String add() {
		return "addUser";
	}
	
	//登录检测
	@RequestMapping(value="/loginCheck")
	public String loginCheck(User user, HttpServletRequest request, HttpSession session, ModelMap map) {
		if(request.getParameter("radio").equals("1")) {
			user.setUserRole(1);//设置登录身份为管理员		
		}else {
			user.setUserRole(0);//设置登录身份为用户	
		}
		User u = userService.getOneUser(user);//获取从数据库查询结果
		
		if(u != null) {//存在就跳转到主页面
			//将用户名保存在session里面
			session.setAttribute("USERNAME", user.getLoginName());
			if(request.getParameter("radio").equals("1"))
			return "home";	
			else
			return "redirect:/allDuty2";
		}else {//不存在跳转到登录页面
			//向前台传递一个登录失败信息
			map.addAttribute("FLAG", 1);
			return "login";
		}
		
	}
}

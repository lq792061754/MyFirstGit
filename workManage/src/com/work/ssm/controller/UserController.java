package com.work.ssm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.work.ssm.pojo.PageUtil;
import com.work.ssm.pojo.User;
import com.work.ssm.service.UserService;

@Controller
public class UserController {
	@Autowired
    private UserService userService;
	
	@RequestMapping(value="/allUser")
	public String showUser(String pIndex, ModelMap map) {
		int pageIndex = 1;//设置初始的当前页，页面显示的都是第一页
        int pageSize = 4;//设置每一页显示几条数据,用于计算总页数，此处设置的值必须与sql语句的limit最后的数值一样
        PageUtil<User> pageUtil = new PageUtil<User>();//初始化工具类
        List<User> lists = new ArrayList<User>();
        if (pIndex != null) {
            pageIndex = Integer.parseInt(pIndex);
        }//对页面上的分页标签传的值,进行获取,也是就点击'上一页或者下一页'传过来的pageindex
        pageUtil.setPageIndex(pageIndex);//保存至工具类
        int number = userService.pageCount();//调用service层方法计算出总数据量，就是多少条数据.
        pageUtil.setPageNumber(number);//保存至工具类
        pageUtil.setPageSize(pageSize);//保存至工具类
        pageUtil.setPageCount((int) Math.ceil((double) (pageUtil
                .getPageNumber() / pageUtil.getPageSize())) + 1);//计算出总页数,并封装到工具类
        int index = (pageIndex - 1) * pageSize;//计算出每一页从数据库中第几条数据开始取值，也就是limit后面的第一个数字
        lists = userService.showList(index);//调用service层的方法，取得数据库中的值
        pageUtil.setList(lists);//保存到工具类中的集合
        map.addAttribute("pageUtil", pageUtil);
		return "showUser";		
	}
	
	@RequestMapping(value="/oneUser")
	public String getOneUser(int id, ModelMap map) {
		User user = userService.getOneUserById(id);
		map.addAttribute("USER", user);
		return "modUser";	
	}
	
	@RequestMapping(value="/insertUser")
	public String addUser(User user, ModelMap map) {
		Date date = new Date();
		user.setCreateTime(date);
		user.setUpdateTime(date);
		user.setUserRole(0);
		userService.insertUser(user);
		map.addAttribute("FLAG", 1);
		return "addUser";	
	}
	
	@RequestMapping(value="/deleteUser")
	public String delUser(int id) {
		userService.deleteUser(id);
		return "redirect:/allUser";	
	}
	@RequestMapping(value="/deleteItems")
	public String deleteItems(@RequestParam(value="items_id",defaultValue="") Integer[] items_id) throws Exception{
		for(int i = 0;i<items_id.length;i++) {
		userService.deleteUser(items_id[i]);
	}
		return "redirect:/allUser";
	}
	
	@RequestMapping(value="/updateUser")
	public String upUser(User user, ModelMap map) {
		user.setUpdateTime(new Date());
		userService.updateUser(user);
		map.addAttribute("FLAG", 1);
		return "modUser";	
	}
	
	@RequestMapping(value="/findUser")
	public String findUser(User user, ModelMap map) {
		List<User> list = userService.getUserByNameOrTel(user);
		map.addAttribute("LIST", list);
		return "showResult";	
	}
}

package com.lq.job.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lq.job.domain.Admin;
import com.lq.job.service.AdminService;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value="login")
    public String adminLogin(Admin admin, HttpServletRequest request) {
        Admin a = adminService.findOneAdmin(admin);
        if (a != null) {
            HttpSession session=request.getSession();//获取session并将userName存入session对象
            session.setAttribute("Admin", a);
            return "admin/main";
        }
        else
            return "redirect:login.html？ERROR=1";
    }
    @RequestMapping(value="loginOut")
    public String loginOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:login.html";
    }
    @RequestMapping(value="changePwd")
    public String changePwd(String newPassword) {
        adminService.changeAdminPwd(newPassword);
        return "admin/changepwd";
    }
    @RequestMapping(value="changePwdIndex")
    public String changePwdIndex() {
        return "admin/changepwd";
    }
    @RequestMapping(value="/")
    public String startPage() {
        return "redirect:login.html";
    }
    @RequestMapping(value="home")
    public String mainPage() {
        return "admin/right";
    }
    @RequestMapping(value="top")
    public String topPage() {
        return "admin/admin_top";
    }
    @RequestMapping(value="left")
    public String leftPage() {
        return "admin/admin_left";
    }
    @RequestMapping(value="right")
    public String rightPage() {
        return "admin/right";
    }
}

package com.work.ssm.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.work.ssm.pojo.DutyList;
import com.work.ssm.pojo.DutyMonth;
import com.work.ssm.pojo.ResultDuty;
import com.work.ssm.pojo.User;
import com.work.ssm.service.DutyListService;
import com.work.ssm.service.DutyMonService;
import com.work.ssm.service.UserService;

@Controller
public class DutyController {
	
	@Autowired
    private UserService userService;
	@Autowired
	private DutyListService ds;
	@Autowired
	private DutyMonService dms;
	
	
	@RequestMapping(value="/allDuty")
    public String showDuty(String month, ModelMap map) {
		int monthid = 0;
		if(month == null) {
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month1 = cal.get(Calendar.MONTH )+1;
			String str = year+"-"+month1;
			monthid = dms.getMonthId(str);
		}else {
			monthid = dms.getMonthId(month);
		}			
		List<ResultDuty> list = ds.getDutyList(monthid);
		map.addAttribute("LIST", list);
    	return "showDuty";
	}
	
	@RequestMapping(value="/allDuty3")
    public String showDuty3(String month, ModelMap map) {
		int monthid = 0;
		if(month == null) {
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month1 = cal.get(Calendar.MONTH )+1;
			String str = year+"-"+month1;
			monthid = dms.getMonthId(str);
		}else {
			monthid = dms.getMonthId(month);
		}			
		List<ResultDuty> list = ds.getDutyList(monthid);
		map.addAttribute("LIST", list);
    	return "serchDuty";
	}
	
	@RequestMapping(value="/allDuty2")
    public String showDuty2(String month, ModelMap map) {
		int monthid = 0;
		if(month == null) {
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month1 = cal.get(Calendar.MONTH )+1;
			String str = year+"-"+month1;
			monthid = dms.getMonthId(str);
		}else {
			monthid = dms.getMonthId(month);
		}			
		List<ResultDuty> list = ds.getDutyList(monthid);
		map.addAttribute("LIST", list);
    	return "showDutyUser";
	}
	
	@RequestMapping(value="/deleteDuty")
    public String delDuty(String month) {
		int monthid = dms.getMonthId(month);
		ds.deleteDutyById(monthid);
		dms.deleteMonthByName(month);
    	return "redirect:/allDuty";
	}
	@RequestMapping(value="/addDuty")
    public String addDuty(ModelMap map) {
		List<User> list = userService.getAllUser();
		map.addAttribute("LIST", list);
    	return "addDuty";
	}
	@RequestMapping(value="/insertDuty")//进行排班
    public String insertDuty(HttpServletRequest request, ModelMap map) {
		String dayNum = request.getParameter("dayNum");
		String yearMonth = request.getParameter("yearMonth");
		String[] a = request.getParameterValues("a");
		DutyMonth d = new DutyMonth();
		d.setCreateTime(new Date());
		d.setUpdateTime(new Date());
		d.setYearMonth(yearMonth);
		d.setDayNums(Integer.parseInt(dayNum));
		dms.insertMonth(d);
		int monthid = dms.getMonthId(yearMonth);
		int userid = 0,sum=1;
		if(a != null){
			while(sum <= Integer.parseInt(dayNum)) {//根据当月天数生成排班
		    for(int i=0; i<a.length; i++){
		        userid=Integer.parseInt(a[i]);
		        DutyList d2 = new DutyList();
		        d2.setCreateTime(new Date());
		        d2.setUpdateTime(new Date());
		        d2.setDuty_months_id(monthid);
		        d2.setSys_user_id(userid);
		        d2.setDutyDates(yearMonth+"-"+(sum+i));
		        ds.insertDuty(d2);
		        if((sum+i) == Integer.parseInt(dayNum))
		        	break;
		    }
		    sum+=a.length;
		 }
		}		
		List<User> list = userService.getAllUser();
		map.addAttribute("LIST", list);
		map.addAttribute("FLAG", 1);
    	return "addDuty";
	}
	@RequestMapping(value="/findDuty")//查询排班
    public String findDuty(HttpServletRequest request, ModelMap map) {
		List<ResultDuty> list = new ArrayList<ResultDuty>();
		String dutyDates = request.getParameter("dutyDates");
		String userName = request.getParameter("userName"); 
		int id = dms.getMonthId(dutyDates);
		System.err.println(id);
		if(userName.equals("")) {
		list = ds.getDutyByMonth(dutyDates, id);
		}else if(dutyDates.equals("")) {
		list = ds.getDutyByName(userName);	
		}else {
		list = ds.getDutyByAll(dutyDates, userName, id);
		}
		map.addAttribute("LIST", list);
    	return "showResult2";
	}
	@RequestMapping(value="/findDuty2")//查询排班
    public String findDuty2(HttpServletRequest request, ModelMap map) {
		List<ResultDuty> list = new ArrayList<ResultDuty>();
		String dutyDates = request.getParameter("dutyDates");
		String userName = request.getParameter("userName"); 
		int id = dms.getMonthId(dutyDates);
		System.err.println(id);
		if(userName.equals("")) {
		list = ds.getDutyByMonth(dutyDates, id);
		}else if(dutyDates.equals("")) {
		list = ds.getDutyByName(userName);	
		}else {
		list = ds.getDutyByAll(dutyDates, userName, id);
		}
		map.addAttribute("LIST", list);
    	return "showResult3";
	}
}

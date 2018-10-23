package com.work.ssm.pojo;

import java.util.Date;

public class DutyMonth {
	private int id;
	private Date createTime;
	private Date updateTime;
	private String yearMonth;
	private int dayNums;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getYearMonth() {
		return yearMonth;
	}
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
	public int getDayNums() {
		return dayNums;
	}
	public void setDayNums(int dayNums) {
		this.dayNums = dayNums;
	}
    
	
}

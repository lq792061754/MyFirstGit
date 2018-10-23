package com.work.ssm.pojo;

import java.util.Date;

public class DutyList {
    private int id;
    private Date createTime;
    private Date updateTime;
    private int duty_months_id;
    private int sys_user_id;
    private String dutyDates;
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
	public int getDuty_months_id() {
		return duty_months_id;
	}
	public void setDuty_months_id(int duty_months_id) {
		this.duty_months_id = duty_months_id;
	}
	public int getSys_user_id() {
		return sys_user_id;
	}
	public void setSys_user_id(int sys_user_id) {
		this.sys_user_id = sys_user_id;
	}
	public String getDutyDates() {
		return dutyDates;
	}
	public void setDutyDates(String dutyDates) {
		this.dutyDates = dutyDates;
	}
    
    
}

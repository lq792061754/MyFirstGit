package com.work.ssm.service;

import com.work.ssm.pojo.DutyMonth;

public interface DutyMonService {
	public int getMonthId(String month);
	public void insertMonth(DutyMonth dy);
	public void deleteMonthByName(String name);
}

package com.work.ssm.mapper;

import com.work.ssm.pojo.DutyMonth;

public interface DutyMonthDao {
	public int getMonthId(String month);
	public void insertMonth(DutyMonth dy);
	public void deleteMonthByName(String name);
}

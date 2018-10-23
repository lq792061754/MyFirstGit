package com.work.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.ssm.mapper.DutyMonthDao;
import com.work.ssm.pojo.DutyMonth;

@Service
public class DutyMonServiceImpl implements DutyMonService {
    @Autowired
	private DutyMonthDao dmd;
	@Override
	public int getMonthId(String month) {
		// TODO Auto-generated method stub
		return dmd.getMonthId(month);
	}
	@Override
	public void insertMonth(DutyMonth dy) {
		dmd.insertMonth(dy);
	}
	@Override
	public void deleteMonthByName(String name) {
		dmd.deleteMonthByName(name);
	}
  
}

package com.work.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.ssm.mapper.DutyDao;
import com.work.ssm.pojo.DutyList;
import com.work.ssm.pojo.ResultDuty;
@Service
public class DutyListServiceImpl implements DutyListService {
    @Autowired
	private DutyDao dd;

	@Override
	public List<ResultDuty> getDutyList(int id) {
		// TODO Auto-generated method stub
		return dd.getDutyList(id);
	}

	@Override
	public void deleteDutyById(int id) {
		dd.deleteDutyById(id);
	}

	@Override
	public void insertDuty(DutyList d) {
		dd.insertDuty(d);
	}

	@Override
	public List<ResultDuty> getDutyByMonth(String dutyDates, int id) {
		return dd.getDutyByMonth(dutyDates, id);
	}

	@Override
	public List<ResultDuty> getDutyByName(String userName) {		
		return dd.getDutyByName(userName);
	}

	@Override
	public List<ResultDuty> getDutyByAll(String dutyDates, String userName, int id) {
		return dd.getDutyByAll(dutyDates, userName, id);
	}
	

}

package com.work.ssm.mapper;

import java.util.List;

import com.work.ssm.pojo.DutyList;
import com.work.ssm.pojo.ResultDuty;

public interface DutyDao {
    public List<ResultDuty> getDutyList(int id);
    public void deleteDutyById(int id);
    public void insertDuty(DutyList d);
    public List<ResultDuty> getDutyByMonth(String dutyDates, int id);
    public List<ResultDuty> getDutyByName(String userName);
    public List<ResultDuty> getDutyByAll(String dutyDates,String userName, int id);
}

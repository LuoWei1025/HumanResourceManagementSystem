package com.swjtu.hrms.service;

import com.github.pagehelper.PageHelper;
import com.swjtu.hrms.dao.LeaveApplicationDAO;
import com.swjtu.hrms.entity.LeaveApplication;
import com.swjtu.hrms.model.AlterFieldInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LeaveApplicationService {
    @Resource
    private LeaveApplicationDAO leaveApplicationDAO;
    public List<LeaveApplication> findAll(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);//启用分页
        return leaveApplicationDAO.findAll();
    }

    public String findstId(String staffId){
        return leaveApplicationDAO.findstId(staffId);
    }

    public void insertTempLeaveApplication(String stId,String leaveDate,String leaveReason,String leaveDays){
        leaveApplicationDAO.insertTempLeaveApplication(stId,leaveDate,leaveReason,leaveDays);
    }

    public int alterField(AlterFieldInfo alterFieldInfo) {
        return leaveApplicationDAO.alterField(alterFieldInfo);
    }
}

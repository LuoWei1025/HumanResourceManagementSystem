package com.swjtu.hrms.dao;

import com.swjtu.hrms.entity.LeaveApplication;
import com.swjtu.hrms.model.AlterFieldInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LeaveApplicationDAO {
    List<LeaveApplication> findAll();
    String findstId(String staffId);//获取序号字段
    void insertTempLeaveApplication(String stId,String leaveDate,String leaveReason,String leaveDays);
    int alterField(AlterFieldInfo alterFieldInfo);
}

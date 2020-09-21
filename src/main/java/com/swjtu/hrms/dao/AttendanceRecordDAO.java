package com.swjtu.hrms.dao;

import com.swjtu.hrms.entity.AttendanceRecord;
import com.swjtu.hrms.model.AlterFieldInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttendanceRecordDAO {
    List<AttendanceRecord> findAll();
    List<AttendanceRecord> findByStaffId(String staffId);
    int alterField(AlterFieldInfo alterFieldInfo);
}

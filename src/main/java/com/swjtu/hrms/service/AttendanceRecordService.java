package com.swjtu.hrms.service;

import com.github.pagehelper.PageHelper;
import com.swjtu.hrms.dao.AttendanceRecordDAO;

import com.swjtu.hrms.entity.AttendanceRecord;
import com.swjtu.hrms.model.AlterFieldInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class AttendanceRecordService {
    @Resource
    private AttendanceRecordDAO attendanceRecordDAO;
    public List<AttendanceRecord> findAll(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);//启动分页
        return attendanceRecordDAO.findAll();
    }

    public List<AttendanceRecord> findByStaffId(String staffId, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);//启用分页
        return attendanceRecordDAO.findByStaffId(staffId);
    }

    public int alterField(AlterFieldInfo alterFieldInfo) {
        return attendanceRecordDAO.alterField(alterFieldInfo);
    }
}

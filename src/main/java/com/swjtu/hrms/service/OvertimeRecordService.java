package com.swjtu.hrms.service;

import com.github.pagehelper.PageHelper;
import com.swjtu.hrms.dao.OvertimeRecordDAO;
import com.swjtu.hrms.entity.OvertimeRecord;
import com.swjtu.hrms.entity.StaffTransferRecord;
import com.swjtu.hrms.model.AlterFieldInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OvertimeRecordService {
    @Resource
    private OvertimeRecordDAO overtimeRecordDAO;
    public List<OvertimeRecord> findAll(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);//启用分页
        return overtimeRecordDAO.findAll();
    }

    public int insertNew(OvertimeRecord overtimeRecord) {
        return overtimeRecordDAO.insertNew(overtimeRecord);
    }

    public int alterField(AlterFieldInfo alterFieldInfo) {
        return overtimeRecordDAO.alterField(alterFieldInfo);
    }

    public List<OvertimeRecord> findByStaffId(String staffId, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);//启用分页
        return overtimeRecordDAO.findByStaffId(staffId);
    }
}

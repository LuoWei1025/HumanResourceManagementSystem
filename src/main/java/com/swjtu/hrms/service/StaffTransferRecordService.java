package com.swjtu.hrms.service;

import com.github.pagehelper.PageHelper;
import com.swjtu.hrms.dao.StaffTransferRecordDAO;
import com.swjtu.hrms.entity.StaffTransferRecord;
import com.swjtu.hrms.model.AlterFieldInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StaffTransferRecordService {
    @Resource
    private StaffTransferRecordDAO staffTransferRecordDAO;

    public List<StaffTransferRecord> findAll(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);//启用分页
        return staffTransferRecordDAO.findAll();
    }

    public int insertNew(StaffTransferRecord staffTransferRecord) {
        return staffTransferRecordDAO.insertNew(staffTransferRecord);
    }

    public int alterField(AlterFieldInfo alterFieldInfo) {
        return staffTransferRecordDAO.alterField(alterFieldInfo);
    }
}
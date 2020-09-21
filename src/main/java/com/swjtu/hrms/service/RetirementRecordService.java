package com.swjtu.hrms.service;

import com.github.pagehelper.PageHelper;

import com.swjtu.hrms.dao.RetirementRecordDAO;

import com.swjtu.hrms.entity.RetirementRecord;
import com.swjtu.hrms.entity.StaffTransferRecord;
import com.swjtu.hrms.model.AlterFieldInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RetirementRecordService {
    @Resource
    private RetirementRecordDAO retirementRecordDAO;

    public List<RetirementRecord> findAll(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);//启用分页
        return retirementRecordDAO.findAll();
    }

    public int insertNew(RetirementRecord retirementRecord) {
        return retirementRecordDAO.insertNew(retirementRecord);
    }

    public int alterField(AlterFieldInfo alterFieldInfo) {
        return retirementRecordDAO.alterField(alterFieldInfo);
    }
}

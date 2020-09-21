package com.swjtu.hrms.service;

import com.github.pagehelper.PageHelper;
import com.swjtu.hrms.dao.DepartmentTrainDAO;
import com.swjtu.hrms.entity.DepartmentTrain;
import com.swjtu.hrms.entity.StaffTransferRecord;
import com.swjtu.hrms.model.AlterFieldInfo;
import com.swjtu.hrms.model.TheDepId;
import com.swjtu.hrms.model.UsefulPosId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentTrainService {
    @Resource
    private DepartmentTrainDAO departmentTrainDAO;

    public List<DepartmentTrain> findAll(String staffId, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);//启用分页
        return departmentTrainDAO.findAll(staffId);
    }

    public int insertNew(DepartmentTrain departmentTrain) {
        return departmentTrainDAO.insertNew(departmentTrain);
    }

    public int alterField(AlterFieldInfo alterFieldInfo) {
        return departmentTrainDAO.alterField(alterFieldInfo);
    }

    public List<TheDepId> findTheDepId(String staffId) {return departmentTrainDAO.findTheDepId(staffId);}
}

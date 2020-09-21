package com.swjtu.hrms.service;

import com.github.pagehelper.PageHelper;
import com.swjtu.hrms.dao.SalaryCalculateDAO;
import com.swjtu.hrms.entity.SalaryCalculate;
import com.swjtu.hrms.entity.UserSalary;
import com.swjtu.hrms.model.AlterFieldInfo;
import com.swjtu.hrms.model.UsefulPosId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SalaryCalculateService {
    @Resource
    private SalaryCalculateDAO salaryCalculateDAO;

    public List<SalaryCalculate> findAll(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);//启用分页
        return salaryCalculateDAO.findAll();
    }

    public UserSalary loadUserSalaryByUsername(String staffId){
        UserSalary userSalary = salaryCalculateDAO.loadUserSalaryByUsername(staffId);
        return userSalary;
    }

    public int insertNew(SalaryCalculate salaryCalculate) {
        return salaryCalculateDAO.insertNew(salaryCalculate);
    }

    public int alterField(AlterFieldInfo alterFieldInfo) {
        return salaryCalculateDAO.alterField(alterFieldInfo);
    }

    public List<UsefulPosId> findUsefulPosId() {return salaryCalculateDAO.findUsefulPosId();}
}
